from flask import Flask, request, render_template
from flask import current_app as app
from application.models import products,Users, Admin,UserOrders
from application.database import db

@app.route("/", methods=["GET", "POST"])
def main():
  # page for user login and admin login
  data=products.query.all()
  return render_template("welcome_page.html",data1=data) 
  

@app.route("/user_signup", methods=["GET", "POST"])
def usersignup():
  # user signup page
  if request.method=="POST":
     #with Session(engine, autoflush=False) as sess:
       #sess.begin()
     if(True):
       try:
         U_new_data=Users(username=request.form["user"],email=request.form["email"],
                          password=request.form["pass"],contact=request.form["mobile"])
         db.session.add(U_new_data)
         db.session.flush()
       except:
         print("rollback /user_signup")
         db.session.rollback()
         return render_template("Error_page.html")
       else:
         db.session.commit()  
         uid=request.form["user"]
         return render_template("user_login.html", uid=uid) 
  return render_template("user_signup.html") 
@app.route("/user_login", methods=["GET", "POST"])
def userlogin():
  # user login page
  if request.method=="POST":   
    data=Users.query.filter(Users.username==request.form["user"]).first()
    try:
      if (data.password==request.form["pass"]):
        data1=products.query.all()
        data2=UserOrders.query.all()
        cat=db.session.query(products.category).distinct().all()
        return render_template("product.html",data1=data1,
                                cat=cat,uid=request.form["user"]) 
      else:
        raise
    except:
      return render_template("Error_page.html")  
  return render_template("user_login.html") 

@app.route("/admin_login", methods=["GET", "POST"])
def admin_login():
  # admin signup page
  if request.method=="POST":
    data=Admin.query.filter(Admin.username==request.form["user"]).first()
    if(data.password==request.form["pass"]):
         product1=products.query.all()
         return render_template("admin_product_database.html",
                           products=product1,aid=request.form["user"]) 
    else:
         return render_template("Error_page.html")
  return render_template("admin_login.html") 

@app.route("/product", methods=["GET", "POST"])
def product():
  data=products.query.all()
  uid=request.args["uid"]
  cat=db.session.query(products.category).distinct().all()
  return render_template("product.html",data1=data, cat=cat,uid=uid) 
  
@app.route("/user_order",methods=["GET","POST"])
def user_order():
  uid=request.args["uid"]
  pname=request.args["pname"]
  category=request.args["category"]
  
  data=products.query.filter(products.product_name==pname).first()
  
  return render_template("user_order.html",data=data,
                         uid=uid,pname=pname,category=category)
  
def up1(qnt,pname):
   with Session(engine, autoflush=False) as sess:
       sess.begin()
       sess.query(products).filter(products.product_name==pname).update({})
       sess.flush()
       sess.commit()
   return None


@app.route("/add_product_by_user", methods=["GET", "POST"])
def add_product_by_user():
  # when user add product, function will update userorder table
  if request.method=="POST":
    user_id=request.args["uid"]
    pname=request.args["pname"]
    category=request.args["category"] 
    qnt=int(request.form["qnt"]) 
    pdetail=products.query.filter(products.product_name==pname).first()
    price=pdetail.rate_per_unit
    unit=pdetail.unit
    
    userdata=UserOrders.query.filter(UserOrders.product_name==pname,  
                           UserOrders.user_id==user_id).first()
    old_quantity=pdetail.quantity
    if(qnt>old_quantity):
      qnt=old_quantity
    new_quantity=old_quantity-qnt
    #with Session(engine, autoflush=False) as sess:
       #sess.begin()
    if(True):
       try:
         if(userdata == None): 
           print("none if") 
           new_data=UserOrders(user_id=user_id,category=category,product_name=pname,
               product_price=price,volume_order=qnt,unit=unit,total=qnt*price)
           db.session.add(new_data)
           db.session.flush()
         else:
           db.session.query(UserOrders).filter(UserOrders.product_name==pname,  
                           UserOrders.user_id==user_id).update({"volume_order":qnt})
           db.session.flush()
         db.session.query(products).filter(True,
                       products.product_name==pname).update({"quantity":new_quantity})
         db.session.flush()
       except:
         print("rollback /add product")
         db.session.rollback()
         return render_template("Error_page.html")
       else:
         db.session.commit()
  data=products.query.all()
  cat=db.session.query(products.category).distinct().all()
  return render_template("product.html",data1=data,cat=cat,uid=user_id) 
    
@app.route("/mycart", methods=["GET","POST"])
def mycart():
  uid=request.args["uid"]
  data=UserOrders.query.filter(UserOrders.user_id==uid).all()
  return render_template("mycart.html",myproducts=data,uid=uid) 



@app.route("/update_mycart", methods=["GET", "POST"])
def update_mycart():
  uid=request.args["uid"]
  pname=request.args["pname"]
  data=UserOrders.query.filter(UserOrders.product_name==pname,  
                           UserOrders.user_id==uid).first()
  pdetail=products.query.filter(products.product_name==pname).first()
  if request.method=="POST":
    vol=request.form["pcount"]
    #with Session(engine, autoflush=False) as sess:
     #sess.begin()
    if(True):
     try:
      db.session.query(UserOrders).filter(UserOrders.product_name==pname,  
                           UserOrders.user_id==uid).update({"volume_order":vol})
      db.session.flush()
     except:
      print("rollback /add product")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
      product1=products.query.all()
      data=UserOrders.query.filter(UserOrders.user_id==uid).all()
      return render_template("mycart.html",myproducts=data,uid=uid)
  return render_template("update_mycart.html",products=data, pdetail=pdetail, uid=uid) 


@app.route("/delete_mycart", methods=["GET", "POST"])
def delete_mycart():
  #with Session(engine, autoflush=False) as sess:
  if(True):
     uid=request.args["uid"]
     pname=request.args["pname"]
     #sess.begin()
     
     try:
      db.session.query(UserOrders).filter(UserOrders.product_name==pname,
                                    UserOrders.user_id==uid).delete()
      db.session.flush()
     except:
      print("rollback delete mycart product")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
  data=UserOrders.query.filter(UserOrders.user_id==uid).all()
  return render_template("mycart.html",myproducts=data,uid=uid) 


  
@app.route("/search",methods=["POST"])
def search():
  query1=request.form["query"]
  uid=request.args["uid"]
  try:
    product1=products.query.filter(products.product_name==query1).all()
    if len(product1)==0:
      product1=products.query.filter(products.category==query1).all()
    if len(product1)==0:
      raise
    cat=db.session.query(products.category).distinct().all()
    return render_template("product.html",data1=product1,cat=cat,uid=uid)
  except:
    product1=products.query.all()
    cat=db.session.query(products.category).distinct().all()
    return render_template("product.html",data1=product1,cat=cat,uid=uid)
  
@app.route("/admin_search",methods=["POST"])
def admin_search():
  query1=request.form["query"]
  aid=request.args["aid"]
  try:
    product1=products.query.filter(products.product_name==query1).all()
    if len(product1)==0:
      product1=products.query.filter(products.category==query1).all()
    if len(product1)==0:
      raise
    return render_template("admin_product_database.html",products=product1,aid=aid)   
  except:
    product1=products.query.all()
    return render_template("admin_product_database.html",products=product1,aid=aid)   
  
  
@app.route("/add_product", methods=["GET", "POST"])
def add_product():
  #add product by database category wise
  aid=request.args["aid"]
  if request.method=="POST":
    pname=request.form["pname"]; psec=request.form["psec"]
    unit=request.form["unit"]
    rate=request.form["rate"]
    stock=request.form["stock"]
    #with Session(engine, autoflush=False) as sess:
     #sess.begin()
    if(True):
     try:
      my_product=products( category=psec,product_name=pname,unit=unit,
                          rate_per_unit=rate, quantity=stock)
      db.session.add(my_product)
      db.session.flush()
     except:
      print("rollback /add product")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
      product1=products.query.all()
      return render_template("admin_product_database.html",products=product1,aid=aid)   
  return render_template("Error_page.html")
  
@app.route("/category_managemnt", methods=["GET", "POST"])
def category_managemnt():
  #add product by database category wise
  aid=request.args["aid"]
  print("cat meth ", request.method)
  if request.method=="POST":
    return render_template("admin_add_product.html",aid=request.args["aid"]) 
  product1=db.session.query(products.category).distinct().all()  
  return render_template("category.html",products=product1,aid=request.args["aid"])

@app.route("/category_filter", methods=["GET", "POST"])
def category_filter():
  #add product by database category wise
  aid=request.args["aid"]
  cat=request.args["cat"]
  data=products.query.filter(products.category==cat).all()  
  return render_template("admin_product_database.html",products=data,aid=aid)   
  

@app.route("/remove_category", methods=["GET", "POST"])
def remove_category():
  #with Session(engine, autoflush=False) as sess:
  if(True):
     aid=request.args["aid"]
     cat=request.args["cat"]
     #sess.begin()
     try:
      db.session.query(products).filter(products.category==cat).delete()
      db.session.flush()
     except:
      print(" delete category")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
  product1=db.session.query(products.category).distinct().all()  
  return render_template("category.html",products=product1,aid=request.args["aid"])
    
  
@app.route("/delete_product", methods=["GET", "POST"])
def delete_product():
  #with Session(engine, autoflush=False) as sess:
  if(True):
     aid=request.args["aid"]
     pname=request.args["pname"]
     #sess.begin()
     try:
      db.session.query(products).filter(products.product_name==pname).delete()
      db.session.flush()
     except:
      print(" delete rollback /add product")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
  product1=products.query.all()
  return render_template("admin_product_database.html",products=product1,aid=aid)
      
        
@app.route("/update_product", methods=["GET", "POST"])
def update_product():
  aid=request.args["aid"]
  pname=request.args["pname"]
  data=products.query.filter(products.product_name==pname).first()
  if request.method=="POST":
    #with Session(engine, autoflush=False) as sess:
     #sess.begin()
    if(True):
     try:
      db.session.query(products).filter(products.product_name==pname).update({
                         "product_name":request.form["pname"],
                         "category":request.form["psec"],
                         "unit":request.form["unit"],
                         "rate_per_unit":request.form["rate"],
                         "quantity":request.form["quantity"]})
      db.session.flush()
     except:
      print("update rollback /add product")
      db.session.rollback()
      return render_template("Error_page.html")
     else:
      db.session.commit()
      #sess.refresh()
    product1=products.query.all()
    return render_template("admin_product_database.html",products=product1,aid=aid)  
  return render_template("update_product.html",products=data, aid=aid) 

