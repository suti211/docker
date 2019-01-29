from flask import Flask, session, redirect, request
from redis import Redis, RedisError
import os
import socket
import logging
from datetime import datetime

LOG_FILENAME = 'Webapp.log'
APP_MASTER_USER = 'admin'
APP_MASTER_PW = "Password123"
logging.basicConfig(filename = LOG_FILENAME, level = logging.DEBUG)

# Connect to Redis
redis = Redis(host = "redis", db = 0, socket_connect_timeout = 2, socket_timeout = 2)

app = Flask(__name__)

@app.route("/")
def hello():
    try:
        visits = redis.incr("counter")
    except RedisError:
        visits = "<i>cannot connect to Redis, counter disabled</i>"

    html = "<h3>Hello {name}!</h3>" \
           "<b>Hostname:</b> {hostname}<br/>" \
           "<b>Visits:</b> {visits}"
    return html.format(name=os.getenv("TESZTVALTOZO", "world"), hostname=socket.gethostname(), visits=visits)

    
@app.route("/login", methods = ['POST'])
def login():
    if user_logged_in():
        return 'Already logged in!'
    else:
        if request.form['username'] == APP_MASTER_USER and request.form['password'] == APP_MASTER_PW:
            Session['username'] = APP_MASTER_USER
            return 'Successfully logged in!'
        else:
            return 'Invalid credentials!'
    
    
def user_logged_in():
    return True if 'username' in session else False
   
   
if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=80)
    app.config['SESSION_TYPE'] = 'memcached'
    app.config['SECRET_KEY'] = 'super secret key'
    logging.debug('Application started up successfully: ' + str(cddatetime.now().strftime("%A, %d. %B %Y %I:%M%p")))
    
    