{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf110
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
\paperw11900\paperh16840\margl1440\margr1440\vieww16000\viewh18840\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 G00301273 Distributed Systems Project.\
\
Included in this zip is the jar and war file necessary for the project.\
\
Full source is at https://github.com/YesManKablam/Distributed-Systems-Project\
\
The Servant.java file should be ran from the jar file before deploying the Tomcat application.\
\
The project will take in an encrypted string and try and decrypt it. \
\
Queues are there and should be Threaded. \
\
Unfortunately, I was not able to fix the queues. The string is decrypted and sent back to the queues, however it does not get displayed at the very end.\
\
System logs do show that it it get\'92s decrypted and it does make it\'92s way back.\
\
It\'92s either adding to the out queue incorrectly, or I\'92m calling it wrong in the CrackerHandler file.\
\
Unfortunately I am out of time.\
\
Code is commented, so it should make sense. I hope.}