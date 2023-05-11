package com.example.data.movies.source.local

import com.example.data.DataFixtures
import com.example.data.movies.source.local.dao.RemoteKeysDao
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class RemoteKeysLocalDataSourceTest{


    @Mock
    internal lateinit var dao: RemoteKeysDao

    private lateinit var cut: RemoteKeysLocalDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        dao = org.mockito.kotlin.mock { }

        cut = RemoteKeysLocalDataSource(dao)
    }

    @Test
    fun `getRemoteKeyByMovieID verify dao is called`() {
        runBlocking {
            // when
            cut.getRemoteKeyByMovieID(DataFixtures.getMovie().id)

            // verify
            verify(dao, times(1)).getRemoteKeyByMovieID(DataFixtures.getMovie().id)

        }
    }

    @Test
    fun `getRemoteKeyByMovieID DAO return RemoteKey success`() {
        runBlocking {
            // given
            Mockito.`when`(dao.getRemoteKeyByMovieID(DataFixtures.getMovie().id))
                .thenAnswer { DataFixtures.getRemoteKeys().first() }

            // when
            val result =  cut.getRemoteKeyByMovieID(DataFixtures.getMovie().id)

            // then
            result shouldBeEqualTo DataFixtures.getRemoteKeys().first()
        }
    }

    @Test
    fun `getRemoteKeyByMovieID DAO return null`() {
        runBlocking {
            // given
            Mockito.`when`(dao.getRemoteKeyByMovieID(DataFixtures.getMovie().id))
                .thenAnswer { null }

            // when
            val result = cut.getRemoteKeyByMovieID(DataFixtures.getMovie().id)

            // then
            result shouldBeEqualTo null
        }
    }

    @Test
    fun `insertAll verify dao is called`() {
        runBlocking {
            // when
            cut.insertAll(DataFixtures.getRemoteKeys())

            // verify
            verify(dao, times(1)).insertAll(DataFixtures.getRemoteKeys())
        }
    }

    @Test
    fun `clearRemoteKeys verify dao is called`() {
        runBlocking {
            // when
            cut.clearRemoteKeys()

            // verify
            verify(dao, times(1)).clearRemoteKeys()
        }
    }

    @Test
    fun `getCreationTime verify dao is called`() {
        runBlocking {
            // when
            cut.getCreationTime()

            // verify
            verify(dao, times(1)).getCreationTime()

        }
    }

}