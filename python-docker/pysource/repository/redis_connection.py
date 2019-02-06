from redis import Redis, RedisError

def get_connection():
    return Redis(host = "redis", db = 0, socket_connect_timeout = 2, socket_timeout = 2)