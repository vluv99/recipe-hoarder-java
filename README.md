# Recipe-hoarder

## General
    A projekt, egy recept tároló honlap és alkalmazás elkészítése volt, egy "online Szakácskönyv". A Recipe-hoarder képes manuálisan receptet beimportálni, valamint bizonyos URL címek alapján egy másik receptes honlapról átimportálni a recept adatokat az adatbázisunkba.

## Features
 * A felhasználó csak bejelentkezés után férhet hozzá a honlaphoz.

 * Amennyiben a felhasználónak még nincs fiókja, a *here*-re kattintva eljuthat a regisztrációs oldalra.

Ha a regisztráció vagy a belépés sikeres volt, akkor erre a holnapra leszünk átirányítva ajol a menüben megjelenik az email amivel beléptünk. Valamint az index page az a recepteket összefoglaló oldal.

 * A recipe-hoarder webes felületen van 2 lehetőség is receptek felöltésére. 
   - Egyik változat amikor kézzel beírjuk az összes információt a mezőkbe, figyelve arra, hogy az **ingredients** és a **directions** egymás után új sorba legyenek.

   - A másik változat amikor a scraperlib áltál feldolgozott honlapok közül ([delish](https://www.delish.com/), [allrecipes](https://www.allrecipes.com/), [nosalty](https://www.nosalty.hu/), [tasty](https://tasty.co/)), ha találunk valahol egy jó receptet, akkor annak az URL-jét kimásoljuk, majd a megfelelő mezőbe bemásolva, az automatikusan hozzá lesz adva a receptjeiknhez.

* A felhasználó által feltöltött összes recept megtalálható a *Recipes* alatt.

    - A recepteket menükbe lehet rendezni. Egy receptet több menübe is bele lehet rakni.

     - A *Go to Recipe* linkre rákattintva eljutunk a az adott recept leíerásához.
     - A receptek között van lehetőség kategória szerint keresni, vagy a recept nevére rákeresni a kereső mezőben.

* A recepteknél van lehetőség az adott receptet kitörölni valamint a hozzávalóit egy gombnyomással átrakni a shopping-list-be

* A *Menus* alatt található az összes menü felsorolva, amikben eltárolva vannak a menübe rakott receptek.

    - A menüket biztonságosan ki lehet törölni anélkül, hogy félni kellene, hogy a recepteket is kitörölnék.

    - Új menüt a *Menus* alatt egy mezőben lehet megadni.

* Végül a shopping list, ahol a receptekből lehet egyszerűen átimportálni hozzávalókat, valamint egyessével hozzáadni azt amit szeretnénk, szintén a felül megadott mezőben.

    - Ha egy hozzávaló mégsem kell, vagy már megvettük, akkor a *Delete* gombbal lehet törölni.