from flask import request

def test_service_method():
    return str({'status': 'success', 'service': 'ok' })