# app-muhyi

hallo aplikasi cuaca ini di buat menggunakan framework quarkus,
oh iya aplikasi ini sudah support swagger dan openAPI yaa so kalian gausah ribet cari url url nya :)),
semoga kalian bisa membaca code ku yaaa hehehe , bantu follow :))

#### Getting Started
1. Cek configurasi application.properties karna ini menggunakan postgresql dan panache
2. Antar hubungan database terdapat di package Models yaaa

#### POST WEATHER

Bagaimana sih jika ingin mengepost ke database ?? nah ini aku udah sediain tamplate json,
agar kalian bisa langsung copy paste ke aplikasi PostMan kalian atau insomnia, ini dia template json nya <br /><br />
``` 
{
    "city" : " ",
    "tempLow" : ,
    "tempHigh" : ,
    "humidity" : ,
    "windSpeed" : ,
    "windBearing" : ,
    "visibility" : ,
    "category" : " ",
    "summary" : " "
}
```
<br /> <br />

#### GETBYID AND DELETE AND PUT

nah sekarang delete dan get by id nih temen temen buat getbyid dan delete dan juga put ini menggunakan time ya temen temen <br />
``` 
http://localhost:8080/weather/10:30:40 
``` 
<br/>

#### GET ALL BY CITY
nah ada juga nih buat mencari data sesuai kota nya contoh kita di sini ingin mencari semua cuaca bekasi <br />
```
http://localhost:8080/weather/all/Bekasi
```
<br />

jadi semoga beberapa petunjuk ini membantu kalian yaaa , makasih dah mampir :))
