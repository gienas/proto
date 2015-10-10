Tomcat SSL obligated !

Microsoft Windows XP [Version 5.1.2600]
(C) Copyright 1985-2001 Microsoft Corp.

C:\Documents and Settings\ukari>cd \program*
The filename, directory name, or volume label syntax is incorrect.

C:\Program Files>cd java

C:\Program Files\Java>cd jdk*

C:\Program Files\Java\jdk1.5.0_11>cd bin

C:\Program Files\Java\jdk1.5.0_11\bin>keytool -genkey -alias tomcat -keypass changeit -keyalg RSA
Enter keystore password:  changeit
What is your first and last name?
  [Unknown]:  localhost
What is the name of your organizational unit?
  [Unknown]:  Information Systems
What is the name of your organization?
  [Unknown]:  Pacific Disaster Center
What is the name of your City or Locality?
  [Unknown]:  Kihei
What is the name of your State or Province?
  [Unknown]:  HI
What is the two-letter country code for this unit?
  [Unknown]:  US
Is CN=compA, OU=Information Systems, O=Pacific Disaster Center, L=Kihei, ST=HI, C=US correct?
  [no]:  yes

C:\Program Files\Java\jdk1.5.0_11\bin>keytool -export -alias tomcat -keypass changeit -file server.crt
Enter keystore password: changeit
Certificate stored in file <server.crt>

C:\Program Files\Java\jdk1.5.0_11\bin>keytool -import -file server.crt -keypass changeit -keystore ..\jre\lib\security\cacerts
Enter keystore password: changeit
Owner: CN=compA, OU=Information Systems, O=Pacific Disaster Center, L=Kihei, ST=HI, C=US
Issuer: CN=compA, OU=Information Systems, O=Pacific Disaster Center, L=Kihei, ST=HI, C=US
Serial number: 462030d8
Valid from: Fri Apr 13 15:39:36 HST 2007 until: Thu Jul 12 15:39:36 HST 2007
Certificate fingerprints:
MD5: CC:3B:FB:FB:AE:12:AD:FB:3E:D 5:98:CB:2E:3B:0A:AD
SHA1: A1:16:80:68:39:C7:58:EA:2F:48:59:AA:1D:73:5F:56:78:CE:A4:CE
Trust this certificate? [no]: yes
Certificate was added to keystore

C:\Program Files\Java\jdk1.5.0_11\bin>

(na podstawie https://wiki.jasig.org/display/CASUM/Demo)