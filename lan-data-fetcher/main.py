import requests
import json
import time

while True:
    response_api = requests.get('http://192.168.2.17/air-data/latest')
    awair_data = response_api.json()

    send_data = requests.post('http://127.0.0.1:8000/air_quality/consume_data/', json.dumps(awair_data))
    time.sleep(5)





