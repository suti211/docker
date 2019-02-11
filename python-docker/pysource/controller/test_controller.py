from flask import Blueprint
from service import test_service

test = Blueprint('test_controller', __name__)

@test.route('/test')
def testEndpoint():
    return test_service.test_service_method()
    
@test.route('/save', methods = ['POST'])
def test_save_data():
    return 'ok'