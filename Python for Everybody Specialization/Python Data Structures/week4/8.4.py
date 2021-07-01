# -*- coding: utf-8 -*-

"""
Created on Jun 15 12:29 PM IST
@author: 10adnan75
"""

get = input('Please enter file name: ')
handle = open(get)
text = list()
for line in handle:
  line = line.rstrip()
  line = line.split()
    for i in line:
      if i in text:
        continue
      else:
        text.append(i)
text.sort()
print(text)
