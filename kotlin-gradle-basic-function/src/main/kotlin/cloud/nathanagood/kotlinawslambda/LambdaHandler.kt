package cloud.nathanagood.kotlinawslambda

import com.fasterxml.jackson.module.kotlin.*
import java.io.InputStream
import java.io.OutputStream

data class HandlerInput(val who: String)
data class HandlerOutput(val message: String)

class LambdaHandler {

	private val mapper = jacksonObjectMapper()

	fun handleFunction(input: InputStream, output: OutputStream) {
		val inputObj = mapper.readValue<HandlerInput>(input)
		mapper.writeValue(output, HandlerOutput("Hello ${inputObj.who}"))
	}
}