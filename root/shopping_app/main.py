import pandas as pd
import os
import cgi
from flask import Flask, render_template, request
from application import config
from application.config import LocalDevelopmentConfig
from application.config import ProductionConfiguration
from application import database
from application.database import db  
# importing local variable "db" from database.py

app=None

def create_app():
 app=Flask(__name__, template_folder="templates")
 if(os.getenv("ENV","development")=="production"):
  raise Exception ("currently no production config is setup..")
 else:
  print("starting local development..")
  app.config.from_object(LocalDevelopmentConfig) 
 db.init_app(app)
 app.app_context().push()
 return app

app=create_app()

from application.controllers import *
if __name__=="__main__":
 with app.app_context():
  db.create_all()
  app.run(debug=True,host="0.0.0.0", port=8080)
