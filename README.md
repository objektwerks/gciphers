GCiphers
--------
>Analytical app for 23 ciphers, using ScalaFx, Os-Lib, Ox, uPickle, jDeploy and Scala 3.

>Also see: [Native GCiphers](https://github.com/objektwerks/gciphers.native.cli)

Install
-------
1. Select [GCiphers](https://www.jdeploy.com/~gciphers)
2. Select a platform to download a compressed app installer.
3. Decompress app installer.
4. Install app by double-clicking app installer.
5. Select app icon to launch app.
>This install has been tested on macOS.

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
2. **Texts:** Number to Texts mappings.
3. **Numbers:** Math properties per selected encoded number.
4. **Encodings:** Encoded numbers across multiple ciphers.
5. **Enter:** Text and number data entry.
6. **Clear:** Clears all data entry and analysis.

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
1. ```java -jar .assembly/gciphers-$version.jar```

Deploy
------
1. edit build.sbt ( jarVersion + version )
2. edit app.conf ( about > alert > contentText )
3. edit package.json ( version + jdeploy / jar )
5. sbt clean test assembly copyAssemblyJar
6. perform github release ( from https://github.com/objektwerks/gciphers )
7. npm login
8. jdeploy publish ( to https://www.jdeploy.com/~gciphers )
9. check email for npm message
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

NPM Versioning
--------------
>The ```build.sbt``` **must** contain a ```semver 3-digit``` **version** number. See: [Npmjs Semver](https://docs.npmjs.com/about-semantic-versioning)

NPM Registry
------------
>GCiphers is deployed to: https://www.npmjs.com/package/gciphers

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