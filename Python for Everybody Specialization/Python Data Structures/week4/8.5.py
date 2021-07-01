# -*- coding: utf-8 -*-

"""
Created on Jun 15 12:29 PM IST
@author: 10adnan75
"""

file = input('Please enter file name: ')
handle = open(file)
count = 0
for line in handle:
	line = line.rstrip()
	if not line.startswith('From '):
		continue
	line = line.split()
	print(line[1])
	count = count + 1
print('There were', count, 'lines in the file with From as the first word')
