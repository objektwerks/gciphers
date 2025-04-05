GCiphers
--------
>Analytical app for 23 ciphers, using ScalaFx, Os-Lib, Ox, uPickle and Scala 3.

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
15. Trigonal
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
1. ```sbt clean compile```

Test
----
1. ```sbt clean test```

Run
---
1. ```sbt run```

Assembly
--------
1. ```sbt clean test assembly copyAssemblyJar```

Execute
-------
1. ```java -jar target/scala-3.6.4/ciphers-3.1.0.jar```
>or:
1. ```java -jar .assembly/ciphers-3.1.0.jar```

Deploy
------
1. edit build.sbt ( jarVersion + version )
2. edit app.conf ( about > alert > contentText )
3. sbt clean test assembly copyAssemblyJar
4. perform github release ( from https://github.com/objektwerks/ciphers )
5. npm login
6. jdeploy publish ( to https://www.jdeploy.com/~ciphers )
7. check email for npm message
>See [jDeploy Docs](https://www.jdeploy.com/docs/manual/#_getting_started) for details.

jDeploy Install
---------------
1. Setup npm account at npmjs.com
2. Install node, which installs npm, which bundles npx.
3. Install jdeploy via npm - *npm install -g jdeploy*
4. Add icon.png ( 256x256 or 512x512 ) to project root and resources.
5. Edit jDeploy *package.json* as required.
6. Add *jdeploy* and *jdeploy-bundle* to .gitignore
>See [jDeploy Docs](https://www.jdeploy.com/docs/manual/#_getting_started) for details.

NPM Registry
------------
>Ciphers is deployed to: https://www.npmjs.com/package/ciphers

License
-------
>Copyright (c) [2023, 2024, 2025] [Objektwerks]

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    * http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.