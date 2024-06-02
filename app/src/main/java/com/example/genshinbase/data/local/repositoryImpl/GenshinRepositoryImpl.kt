package com.example.genshinbase.data.local.repositoryImpl

import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType
import com.example.genshinbase.data.local.repository.GenshinRepository
import com.example.genshinbase.domain.models.CharacterUI
import com.example.genshinbase.domain.models.ElementUI
import com.example.genshinbase.domain.models.RarityUI
import com.example.genshinbase.domain.models.RegionUI
import com.example.genshinbase.domain.models.WeaponTypeUI
import com.example.genshinbase.domain.models.WeaponUI
import javax.inject.Inject

class GenshinRepositoryImpl @Inject constructor(private val genshinRepository: GenshinRepository) {

    suspend fun insertCharacterModel(characterModel: CharacterModel): Long {
        return genshinRepository.insert(characterModel)
    }

    suspend fun getCharacterById(id: Long): CharacterUI {
        val character = genshinRepository.getCharacterById(id)
        val weapon = genshinRepository.getWeaponById(character.weaponId)
        val region = genshinRepository.getRegionById(character.regionId)
        val element = genshinRepository.getElementById(character.elementId)
        val rarity = genshinRepository.getRarityById(character.rarityId)
        val weaponRarity = genshinRepository.getRarityById(weapon.rarityId)
        return character.let {
            CharacterUI(
                characterId = it.characterId,
                name = it.name,
                region = RegionUI(regionId = region.regionId, name = region.name),
                rarity = rarity.starts.toLong(),
                element = ElementUI(elementId = element.elementId, name = element.name),
                url = it.url,
                weapon = weapon.let {
                    WeaponUI(
                        weaponId = it.weaponId,
                        name = it.name,
                        rarity = weaponRarity.starts.toLong(),
                        weaponTypeId = it.weaponTypeId,
                        url = it.url
                    )
                },
                description = it.description
            )
        }
    }

    suspend fun getAllCharacters(): List<CharacterUI> {
        val characters = genshinRepository.getAllCharacters()
        return characters.map {
            val character = it
            val weapon = genshinRepository.getWeaponById(character.weaponId)
            val region = genshinRepository.getRegionById(character.regionId)
            val element = genshinRepository.getElementById(character.elementId)
            val rarity = genshinRepository.getRarityById(character.rarityId)
            val weaponRarity = genshinRepository.getRarityById(weapon.rarityId)
            character.let {
                println(it)
                CharacterUI(
                    characterId = it.characterId,
                    name = it.name,
                    region = RegionUI(regionId = region.regionId, name = region.name),
                    rarity = rarity.starts.toLong(),
                    element = ElementUI(elementId = element.elementId, name = element.name),
                    url = it.url,
                    weapon = weapon.let {
                        WeaponUI(
                            weaponId = it.weaponId,
                            name = it.name,
                            rarity = weaponRarity.starts.toLong(),
                            weaponTypeId = it.weaponTypeId,
                            url = it.url
                        )
                    },
                    description = it.description
                )
            }
        }
    }

    suspend fun deleteCharacter(characterUI: CharacterUI) {
        val character = CharacterModel(
            characterId = characterUI.characterId,
            name = characterUI.name,
            weaponId = characterUI.weapon.weaponTypeId,
            regionId = characterUI.region.regionId,
            rarityId = characterUI.rarity,
            elementId = characterUI.element.elementId,
            url = characterUI.url,
            description = characterUI.description
        )
        genshinRepository.delete(character)
    }

    suspend fun insertElement(elementUI: ElementUI): Long {
        val element = Element(
            elementId = elementUI.elementId,
            name = elementUI.name
        )
        val id = genshinRepository.insert(element)
        return id
    }

    suspend fun getElementById(id: Long): ElementUI? {
        val element = genshinRepository.getElementById(id)
        return element?.let {
            ElementUI(
                elementId = it.elementId,
                name = it.name
            )
        }
    }

    suspend fun getAllElements(): List<ElementUI> {
        val elements = genshinRepository.getAllElements()
        return elements.map {
            ElementUI(
                elementId = it.elementId,
                name = it.name
            )
        }
    }

    suspend fun deleteElement(elementUI: ElementUI) {
        val element = Element(
            elementId = elementUI.elementId,
            name = elementUI.name
        )
        genshinRepository.delete(element)
    }

    suspend fun insertRarity(rarityUI: RarityUI): Long {
        val rarity = Rarity(
            rarityId = rarityUI.rarityId,
            starts = rarityUI.stars
        )
        val id = genshinRepository.insert(rarity)
        return id
    }

    suspend fun getRarityById(id: Long): RarityUI? {
        val rarity = genshinRepository.getRarityById(id)
        return rarity?.let {
            RarityUI(
                rarityId = it.rarityId,
                stars = it.starts
            )
        }
    }

    suspend fun getAllRarities(): List<RarityUI> {
        val rarities = genshinRepository.getAllRarities()
        return rarities.map {
            RarityUI(
                rarityId = it.rarityId,
                stars = it.starts
            )
        }
    }

    suspend fun deleteRarity(rarityUI: RarityUI) {
        val rarity = Rarity(
            rarityId = rarityUI.rarityId,
            starts = rarityUI.stars
        )
        genshinRepository.delete(rarity)
    }

    suspend fun insertRegion(regionUI: RegionUI): Long {
        val region = Region(
            regionId = regionUI.regionId,
            name = regionUI.name
        )
        return genshinRepository.insert(region)
    }

    suspend fun getRegionById(id: Long): RegionUI? {
        val region = genshinRepository.getRegionById(id)
        return region?.let {
            RegionUI(
                regionId = it.regionId,
                name = it.name
            )
        }
    }

    suspend fun getAllRegions(): List<RegionUI> {
        val regions = genshinRepository.getAllRegions()
        return regions.map {
            RegionUI(
                regionId = it.regionId,
                name = it.name
            )
        }
    }

    suspend fun deleteRegion(regionUI: RegionUI) {
        val region = Region(
            regionId = regionUI.regionId,
            name = regionUI.name
        )
        genshinRepository.delete(region)
    }

    suspend fun insertWeaponType(weaponTypeUI: WeaponTypeUI): Long {
        val weaponType = WeaponType(
            weaponTypeId = weaponTypeUI.weaponTypeId,
            name = weaponTypeUI.name
        )
        val weaponTypeId = genshinRepository.insert(weaponType)
        return weaponTypeId
    }

    suspend fun getWeaponTypeById(id: Long): WeaponTypeUI? {
        val weaponType = genshinRepository.getWeaponTypeById(id)
        return weaponType?.let {
            WeaponTypeUI(
                weaponTypeId = it.weaponTypeId,
                name = it.name
            )
        }
    }

    suspend fun getAllWeaponTypes(): List<WeaponTypeUI> {
        val weaponTypes = genshinRepository.getAllWeaponTypes()
        return weaponTypes.map {
            WeaponTypeUI(
                weaponTypeId = it.weaponTypeId,
                name = it.name
            )
        }
    }

    suspend fun deleteWeaponType(weaponTypeUI: WeaponTypeUI) {
        val weaponType = WeaponType(
            weaponTypeId = weaponTypeUI.weaponTypeId,
            name = weaponTypeUI.name
        )
        genshinRepository.delete(weaponType)
    }

    suspend fun insertWeapon(weaponModel: Weapon): Long {

        val weapon = Weapon(
            weaponId = weaponModel.weaponId,
            name = weaponModel.name,
            rarityId = weaponModel.rarityId,
            weaponTypeId = weaponModel.weaponTypeId,
            url = weaponModel.url
        )
        return genshinRepository.insert(weapon)
    }

    suspend fun getWeaponById(id: Long): WeaponUI? {
        val weapon = genshinRepository.getWeaponById(id)
        val rarity = genshinRepository.getRarityById(weapon.rarityId)
        return weapon.let {
            WeaponUI(
                weaponId = it.weaponId,
                name = it.name,
                rarity = rarity.starts.toLong(),
                weaponTypeId = it.weaponTypeId,
                url = it.url
            )
        }
    }

    suspend fun getAllWeapons(): List<WeaponUI> {
        val weapons = genshinRepository.getAllWeapons()
        return weapons.map {
            val rarity = genshinRepository.getRarityById(it.rarityId)
            WeaponUI(
                weaponId = it.weaponId,
                name = it.name,
                rarity = rarity.starts.toLong(),
                weaponTypeId = it.weaponTypeId,
                url = it.url
            )
        }
    }

}