package teko.ch.kotlinvuefinance.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestPropertySource
import org.springframework.web.client.RestClientException
import teko.ch.kotlinvuefinance.dtos.EntryDto
import teko.ch.kotlinvuefinance.dtos.NewEntryDto

@TestPropertySource(locations = ["/testing.properties"])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class IncomeControllerTest {

    @LocalServerPort
    lateinit var port: String

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `get all income entries (index)`() {
        // Arrange
        val url = "http://localhost:$port/api/incomes/"

        // Act
        val response = testRestTemplate.getForObject(url, String::class.java)

        // Assert
        assertThat(response.toString()).isEqualTo("[" +
                "{\"id\":2,\"description\":\"Found on Street\",\"amount\":0.05}," +
                "{\"id\":1,\"description\":\"Salary\",\"amount\":400.0}" +
                "]")
    }

    @Test
    fun `create new entry (store)`() {
        // Arrange
        val url = "http://localhost:$port/api/incomes/"
        val request = NewEntryDto("Testdescription", 10.00)

        // Act
        val response = testRestTemplate.postForObject(url, request, String::class.java)

        // Assert
        assertThat(response.toString()).isEqualTo("{\"id\":3,\"description\":\"Testdescription\",\"amount\":10.0}")
    }

    @Test
    fun `delete new entry (destroy)`() {
        // Arrange
        val url = "http://localhost:$port/api/incomes/3"

        // Act
        testRestTemplate.delete(url)

        // Assert
        assertThrows<RestClientException> {
            testRestTemplate.getForEntity(url, EntryDto::class.java)
        }
    }
}