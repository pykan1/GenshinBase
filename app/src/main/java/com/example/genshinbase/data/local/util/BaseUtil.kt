package com.example.genshinbase.data.local.util

import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.repositoryImpl.GenshinRepositoryImpl
import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI
import com.example.genshinbase.domain.models.WeaponUI

object BaseUtil {

    suspend fun insertCharacters(repository: GenshinRepositoryImpl, doSuccess: () -> Unit) {
        val regionTest = repository.insertRegion(RegionUI(0, name = "Снежный"))

        // Вставка данных о типах оружия
        val bowType = repository.insertWeaponType(WeaponTypeUI(0, "Bow"))
        val catalystType = repository.insertWeaponType(WeaponTypeUI(1, "Catalyst"))
        val claymoreType = repository.insertWeaponType(WeaponTypeUI(2, "Claymore"))
        val swordType = repository.insertWeaponType(WeaponTypeUI(4, "Sword"))
        val polearmType = repository.insertWeaponType(WeaponTypeUI(5, "Polearm"))

        // Вставка данных об элементах
        val pyroElement = repository.insertElement(ElementUI(0, "Pyro"))
        val hydroElement = repository.insertElement(ElementUI(1, "Hydro"))
        val electroElement = repository.insertElement(ElementUI(2, "Electro"))
        val cryoElement = repository.insertElement(ElementUI(3, "Cryo"))
        val geoElement = repository.insertElement(ElementUI(4, "Geo"))
        val anemoElement = repository.insertElement(ElementUI(5, "Anemo"))
        val noneElement = repository.insertElement(ElementUI(6, "None"))

        // Вставка данных о редкости
        val fourStarRarity = repository.insertRarity(RarityUI(0, 4))
        val fiveStarRarity = repository.insertRarity(RarityUI(1, 5))

        // Вставка данных об оружии
        val weaponThoma = repository.insertWeapon(Weapon(0, "Favonius Lance", fourStarRarity, polearmType, "https://static.wikia.nocookie.net/gensin-impact/images/5/57/Weapon_Favonius_Lance.png/revision/latest?cb=20201116154512"))
        val weaponGorou = repository.insertWeapon(Weapon(1, "Favonius Warbow", fourStarRarity, bowType, "https://static.wikia.nocookie.net/gensin-impact/images/8/85/Weapon_Favonius_Warbow.png/revision/latest?cb=20201120003145"))
        val weaponItto = repository.insertWeapon(Weapon(2, "Serpent Spine", fourStarRarity, claymoreType, "https://static.wikia.nocookie.net/gensin-impact/images/8/88/Weapon_Serpent_Spine.png/revision/latest?cb=20201116035126"))
        val weaponYunJin = repository.insertWeapon(Weapon(3, "Dragon's Bane", fourStarRarity, polearmType, "https://static.wikia.nocookie.net/gensin-impact/images/2/24/Weapon_Dragon%27s_Bane.png/revision/latest?cb=20201116033629"))
        val weaponShenhe = repository.insertWeapon(Weapon(4, "Calamity Queller", fiveStarRarity, polearmType, "https://static.wikia.nocookie.net/gensin-impact/images/8/8b/Weapon_Calamity_Queller.png/revision/latest?cb=20231219232455"))
        val weaponYae = repository.insertWeapon(Weapon(5, "Kagura's Verity", fiveStarRarity, catalystType, "https://static.wikia.nocookie.net/gensin-impact/images/b/b7/Weapon_Kagura%27s_Verity.png/revision/latest?cb=20220216070811"))
        val weaponAyato = repository.insertWeapon(Weapon(6, "Haran Geppaku Futsu", fiveStarRarity, swordType, "https://static.wikia.nocookie.net/gensin-impact/images/8/85/Weapon_Haran_Geppaku_Futsu.png/revision/latest?cb=20220330041349"))
        val weaponYelan = repository.insertWeapon(Weapon(7, "Aqua Simulacra", fiveStarRarity, bowType, "https://static.wikia.nocookie.net/gensin-impact/images/c/cd/Weapon_Aqua_Simulacra.png/revision/latest?cb=20220531054835"))
        val weaponAloy = repository.insertWeapon(Weapon(8, "Predator", fourStarRarity, bowType, "https://static.wikia.nocookie.net/gensin-impact/images/2/2e/Weapon_Predator.png/revision/latest?cb=20211228193811"))

        // Вставка данных о персонажах
        val characters = listOf(
            CharacterModel(1, "Thoma", weaponThoma, regionTest, fourStarRarity, pyroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Yelan_Game.png", "Тома — верный домоправитель клана Камисато, известный своей надежностью и доброжелательностью."),
            CharacterModel(2, "Gorou", weaponGorou, regionTest, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Character_Gorou_Game.png", "Горо — смелый и надежный генерал армии Ватадзуми, всегда готов защищать своих товарищей."),
            CharacterModel(3, "Itto", weaponItto, regionTest, fiveStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/ae/Character_Arataki_Itto_Game.png", "Итто — лидер банды Аратаки, известный своей мощной силой и беззаботным характером."),
            CharacterModel(4, "Yun Jin", weaponYunJin, regionTest, fourStarRarity, geoElement, "https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Yun_Jin_Game.png", "Юнь Цзинь — талантливая актриса из Ли Юэ, сочетающая традиции и современность в своих выступлениях."),
            CharacterModel(5, "Shenhe", weaponShenhe, regionTest, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/35/Character_Shenhe_Game.png", "Шэньхэ — загадочная воительница из Ли Юэ, обладающая мощной ледяной силой."),
            CharacterModel(6, "Yae", weaponYae, regionTest, fiveStarRarity, electroElement, "https://static.wikia.nocookie.net/gensin-impact/images/d/d1/Character_Yae_Miko_Game.png", "Яэ Мико — умная и загадочная жрица Гранд Наруками, владеющая электро элементом."),
            CharacterModel(7, "Ayato", weaponAyato, regionTest, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Character_Kamisato_Ayato_Game.png", "Аято Камисато — глава клана Камисато, известный своей мудростью и стратегическим мышлением."),
            CharacterModel(8, "Yelan", weaponYelan, regionTest, fiveStarRarity, hydroElement, "https://static.wikia.nocookie.net/gensin-impact/images/b/be/Character_Yelan_Game.png", "Е Лань — таинственная и элегантная разведчица, обладающая мастерством обращения с луком."),
            CharacterModel(9, "Aloy", weaponAloy, regionTest, fiveStarRarity, cryoElement, "https://static.wikia.nocookie.net/gensin-impact/images/3/34/Character_Aloy_Game.png", "Элой — охотница из другого мира, сражающаяся с механическими существами и владеющая крио силой.")
        )

        characters.forEach {
            repository.insertCharacterModel(it)
        }
        doSuccess()
    }
}
