import os
basedir=os.path.abspath(os.path.dirname(__file__))
#print(basedir,"*********base dir -----")
class Config():
 DEBUG=False
 SQLITE_DB_DIR=None
 SQLALCHEMY_DATABASE_URI=None
 SQLALCHEMY_TRACK_MODIFICATIONS=False
 
 
class LocalDevelopmentConfig(Config):
 SQLITE_DB_DIR=os.path.join(basedir,"../db")
 #print(SQLITE_DB_DIR,"--------SQLITE_DB_DIR")
 SQLALCHEMY_DATABASE_URI="sqlite:///"+os.path.join(SQLITE_DB_DIR,"db2.sqlite3")  
 DEBUG=True
 
 
class ProductionConfiguration(Config):
 SQLITE_DB_DIR=os.path.join(basedir,"/db")
 SQLALCHEMY_DATABASE_URI="sqlite:///"+os.path.join(SQLITE_DB_DIR,"db2.sqlite3")  
 DEBUG=False
 
 
