# -*- coding: utf-8 -*-

"""
Created on Jun 29 12:29 PM IST
@author: 10adnan75
"""

import urllib.request, urllib.parse, urllib.error
import json

url = input('Enter location: ')
data = urllib.request.urlopen(url).read()
info = json.loads(data)
info = info['comments']
print ('Retrieving', url, '\nRetrieved', len(data), 'characters', '\nCount:', len(info))
num = 0
for item in info:
    num += int(item['count'])
    
print ('Sum:', num)
