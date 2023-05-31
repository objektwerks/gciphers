Ciphers
-------
>Ciphers app.

Ciphers
_______
1. Ordinal
  ReverseOrdinal(value: Int) extends AnyVal
  Reduction(value: Int) extends AnyVal 
  ReverseReduction(value: Int) extends AnyVal 
  Standard(value: Int) extends AnyVal
  ReverseStandard(value: Int) extends AnyVal
  Latin(value: Int) extends AnyVal  
  Sumerian(value: Int) extends AnyVal
  ReverseSumerian(value: Int) extends AnyVal
  Primes(value: Int) extends AnyVal
  ReversePrimes(value: Int) extends AnyVal
  Fibonacci(value: Int) extends AnyVal
  Squares(value: Int) extends AnyVal
  ReverseSquares(value: Int) extends AnyVal
  Trigonal(value: Int) extends AnyVal
  ReverseTrigonal(value: Int) extends AnyVal
  SingleReduction(value: Int) extends AnyVal
  ReverseSingleReduction(value: Int) extends AnyVal
  Keypad(value: Int) extends AnyVal
  Chaldean(value: Int) extends AnyVal
  Septenary(value: Int) extends AnyVal
  Satanic(value: Int) extends AnyVal
  ReverseSatanic(value: Int) extends AnyVal

Features
--------
1. **Enter:** Text encoding across multiple ciphers.
2. **Encodings:** Encoded numbers across multiple ciphers.
3. **Date:** Date properties, encodings and date diff.
4: **Numbers:** Math properties per enciphered number.

Build
-----
1. sbt clean compile

Test
----
1. sbt clean test

Run
---
1. sbt run

Assembly
--------
>To build for a "mac", "m1', "win" or "linux" os target:
1. sbt -Dtarget="mac" clean test assembly copyAssemblyJar
2. sbt -Dtarget="m1" clean test assembly copyAssemblyJar
3. sbt -Dtarget="win" clean test assembly copyAssemblyJar
4. sbt -Dtarget="linux" clean test assembly copyAssemblyJar

Execute
-------
>To execute an assembled jar locally:
1. java -jar .assembly/pool-balance-mac-0.3.jar
2. java -jar .assembly/pool-balance-m1-0.3.jar
3. java -jar .assembly/pool-balance-win-0.3.jar
4. java -jar .assembly/pool-balance-linux-0.3.jar

Deploy
------
>Consider these options:
1. [jDeploy](https://www.npmjs.com/package/jdeploy)
2. [Conveyor](https://hydraulic.software/index.html)

License
-------
>Copyright (c) [2023] [Objektwerks]

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    * http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.