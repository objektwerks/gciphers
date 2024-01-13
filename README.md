Ciphers
-------
>Cipher analysis app using ScalaFx and Scala 3.

Ciphers
-------
1. Ordinal
2. ReverseOrdinal
3. Reduction 
4. ReverseReduction 
5. Standard
6. ReverseStandard
7. Latin  
8. Sumerian
9. ReverseSumerian
10. Primes
11. ReversePrimes
12. Fibonacci
13. Squares
14. ReverseSquares
15. trigonal
16. ReverseTrigonal
17. SingleReduction
18. ReverseSingleReduction
19. Keypad
20. Chaldean
21. Septenary
22. Satanic
23. ReverseSatanic

Features
--------
1. **Date:** Date properties, encodings and date diff.
2. **Numbers:** Math properties per selected encoded number.
3. **Encodings:** Encoded numbers across multiple ciphers.
4. **Enter:** Text and number data entry.
5. **Clear:** Clears all data entry and analysis.

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
1. java -jar .assembly/pool-balance-mac-2.5.jar
2. java -jar .assembly/pool-balance-m1-2.5.jar
3. java -jar .assembly/pool-balance-win-2.5.jar
4. java -jar .assembly/pool-balance-linux-2.5.jar

Deploy
------
>Consider these options:
1. [jDeploy](https://www.npmjs.com/package/jdeploy)
2. [Conveyor](https://hydraulic.software/index.html)

License
-------
>Copyright (c) [2023, 2024] [Objektwerks]

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    * http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
