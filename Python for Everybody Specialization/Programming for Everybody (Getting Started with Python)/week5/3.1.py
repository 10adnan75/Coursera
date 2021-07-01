# -*- coding: utf-8 -*-

"""
Created on Jun 22 12:29 PM IST
@author: 10adnan75
"""

try:
	h = input("please input your hour: ")
	hour = float(h)
	r = input("please input your rate: ")
	rate = float(r)
	if hour < 0:
		print("Please, input positive numeric")
	elif rate < 0:
		print("Please, input positive numeric")
	elif hour > 40:
		print("%.2f" % (40 * rate + (hour-40) * 1.5 * rate))
	else:
		print("%.2f" % (hour * rate))

except:
		print("Please, input a numeric!")
