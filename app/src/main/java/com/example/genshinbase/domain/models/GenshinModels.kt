package com.example.genshinbase.domain.models

data class CharacterUI(
    val characterId: Long,
    val name: String,
    val weapon: WeaponUI,
    val region: RegionUI,
    val rarity: Long,
    val element: ElementUI,
    val url: String,
    val description: String,
)

data class ElementUI(
    val elementId: Long,
    val name: String
)

data class RarityUI(
    val rarityId: Long,
    val stars: Int
)

data class RegionUI(
    val regionId: Long,
    val name: String
)

data class WeaponTypeUI(
    val weaponTypeId: Long,
    val name: String
)

data class WeaponUI(
    val weaponId: Long,
    val name: String,
    val rarity: Long,
    val weaponTypeId: Long,
    val url: String,
)