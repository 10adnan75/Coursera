# -*- coding: utf-8 -*-

"""
Created on Jun 29 12:29 PM IST
@author: 10adnan75
"""

import urllib.request, urllib.parse, urllib.error
import json

serviceurl = 'http://python-data.dr-chuck.net/geojson'
address = input('Enter location: ')
url = serviceurl + '?' + urllib.parse.urlencode({'sensor':'false', 'address':  address})
data = urllib.request.urlopen(url).read().decode()
info = json.loads(data)
info = info['results']
print ('Retrieving', url, '\nRetrieved', len(data), 'caracters')
for item in info:
    key = item['place_id']
    
print ('Place id:', key)
