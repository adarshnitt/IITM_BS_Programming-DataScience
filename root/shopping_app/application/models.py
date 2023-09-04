from application.database import db
from sqlalchemy import Column, Integer,String,UniqueConstraint,ForeignKey

class products(db.Model):
  __tablename__="product"
  product_name=db.Column(db.String, primary_key=True, unique=True)
  category=db.Column(db.String)
  unit=db.Column(db.String)
  rate_per_unit=db.Column(db.Integer )
  quantity=db.Column(db.Integer )

class Users(db.Model):
  __tablename__="users"
  username=db.Column(db.String, primary_key=True)
  email=db.Column(db.String)
  contact=db.Column(db.Integer)
  password=db.Column(db.String)
class Admin(db.Model):
  __tablename__="admin"
  username=db.Column(db.String, primary_key=True)
  password=db.Column(db.String, unique=True)

class UserOrders(db.Model):
  __tablename__="user_order"
  index=db.Column(db.Integer,primary_key=True)
  user_id=db.Column(db.String)
  category=db.Column(db.String)
  product_name=db.Column(db.String)
  product_price=db.Column(db.Integer)
  volume_order=db.Column(db.Integer)
  unit=db.Column(db.String)
  total=db.Column(db.Integer)
  


