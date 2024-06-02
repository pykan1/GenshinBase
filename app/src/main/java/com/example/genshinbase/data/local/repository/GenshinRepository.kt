package com.example.genshinbase.data.local.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.genshinbase.data.local.models.CharacterModel
import com.example.genshinbase.data.local.models.Element
import com.example.genshinbase.data.local.models.Rarity
import com.example.genshinbase.data.local.models.Region
import com.example.genshinbase.data.local.models.Weapon
import com.example.genshinbase.data.local.models.WeaponType


@Dao
interface GenshinRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterModel): Long

    @Query("SELECT * FROM character WHERE characterId = :id")
    suspend fun getCharacterById(id: Long): CharacterModel

    @Query("SELECT * FROM character")
    suspend fun getAllCharacters(): List<CharacterModel>

    @Delete
    suspend fun delete(character: CharacterModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(element: Element): Long

    @Query("SELECT * FROM element WHERE elementId = :id")
    suspend fun getElementById(id: Long): Element

    @Query("SELECT * FROM element")
    suspend fun getAllElements(): List<Element>

    @Delete
    suspend fun delete(element: Element)

    @Insert
    suspend fun insert(rarity: Rarity): Long

    @Query("SELECT * FROM rarity WHERE rarityId = :id")
    suspend fun getRarityById(id: Long): Rarity

    @Query("SELECT * FROM rarity")
    suspend fun getAllRarities(): List<Rarity>

    @Delete
    suspend fun delete(rarity: Rarity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(region: Region): Long

    @Query("SELECT * FROM region WHERE regionId = :id")
    suspend fun getRegionById(id: Long): Region

    @Query("SELECT * FROM region")
    suspend fun getAllRegions(): List<Region>

    @Delete
    suspend fun delete(region: Region)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weaponType: WeaponType): Long

    @Query("SELECT * FROM weaponType WHERE weaponTypeId = :id")
    suspend fun getWeaponTypeById(id: Long): WeaponType?

    @Query("SELECT * FROM weaponType")
    fun getAllWeaponTypes(): List<WeaponType>

    @Delete
    suspend fun delete(weaponType: WeaponType)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weapon: Weapon): Long

    @Query("SELECT * FROM weapon WHERE weaponId = :id")
    suspend fun getWeaponById(id: Long): Weapon

    @Query("SELECT * FROM weapon")
    suspend fun getAllWeapons(): List<Weapon>

    @Delete
    suspend fun delete(weapon: Weapon)
}