# -*- coding: utf-8 -*-

"""
Created on Jun 15 12:29 PM IST
@author: 10adnan75
"""

import xml.etree.ElementTree as ET
import sqlite3
conn = sqlite3.connect('trackdb.sqlite')
cur = conn.cursor()

cur.executescript('''
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Album;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS Track;''')

cur.execute(''' CREATE TABLE Artist (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name TEXT UNIQUE
    );''')

cur.execute(''' CREATE TABLE Genre (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name TEXT UNIQUE
    );''') 

cur.execute(''' CREATE TABLE Album (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    artist_id INTEGER,
    title TEXT UNIQUE
    );''')

cur.execute(''' CREATE TABLE Track (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    title TEXT UNIQUE,
    album_id INTEGER,
    genre_id INTEGER,
    len INTEGER,
    rating INTEGER,
    count INTEGER
    );''')

tree = ET.parse(r'C:\Users\\10adnan75\Documents\Python for Everybody Specialization\Using Databases with Python\week3\Library.xml')

root = tree.getroot()
itlist = root.findall('./dict/dict//dict')

def lookup(dic, key):
    found = False
    for child in dic:
        if found: return child.text
        if child.tag == 'key' and child.text == key:
            found = True
    return None

print('Dict count', len(itlist))
for entry in itlist:
    if (lookup(entry,'Track ID') is None) : continue

    name = lookup(entry, 'Name')
    artist = lookup(entry, 'Artist')
    album = lookup(entry, 'Album')
    genre = lookup(entry, 'Genre')
    length = lookup(entry, 'Total Time')
    count = lookup(entry, 'Play Count')
    rating = lookup(entry, 'Rating')

    if name is None or artist is None or album is None or genre is None : continue

    print(name, artist, album, count, rating, length)

    cur.execute('''INSERT or IGNORE INTO Artist (name)
        VALUES (?)''', (artist,))

    cur.execute('SELECT id FROM Artist WHERE name = ?', (artist,))
    artist_id = cur.fetchone()[0]

    cur.execute('''INSERT OR IGNORE INTO Genre (name)
        VALUES (?)''', ( genre, ) )

    cur.execute('SELECT id FROM Genre WHERE name = ?', ( genre, ) )
    genre_id = cur.fetchone()[0]

    cur.execute('''INSERT or IGNORE INTO Album (title, artist_id)
        VALUES (?,?)''', (album, artist_id))
    
    cur.execute('SELECT id FROM Album WHERE title = ?', (album,))
    album_id = cur.fetchone()[0]

    cur.execute('''INSERT OR REPLACE INTO Track
        (title, album_id, genre_id, len, rating, count)
        VALUES (?,?,?,?,?,?)''',
        (name, album_id, genre_id, length, rating, count))

    conn.commit()
