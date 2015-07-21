package example
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js
import org.scalajs.dom.html
import scala.util.Random
//import scalatags.Text.all._
import scalatags.JsDom.all._
import scalatags.stylesheet._


@JSExport
object ScalaJSExample {
	trait exampleStyle extends StyleSheet {
   def highlightedImproved = cls(
     color := "green",
     fontWeight := "bold"
   )
   
   def fade = cls.hover(
     opacity := 0.2
   )
   
   def glitter = cls.hover(
     backgroundColor := "pink"
   )
  }
  
  val exampleStyle = Sheet[exampleStyle]
  val myStyle = dom.document.createElement("style")
  myStyle.textContent = exampleStyle.styleSheetText
  println(exampleStyle.styleSheetText)
  dom.document.head.appendChild(myStyle)
  
  import exampleStyle._
  
  @JSExport
  def main(container: html.Div): Unit = {
    val stations = List(
        "Vila Madalena",
        "Paraíso",
        "Ana Rosa",
        "Consolação",
        "Trianon",
        "Brás",
        "Luz",
        "Brigadeiro",
        "Tatuapé",
        "Belém"
    )
    val myInput = input().render
    val myOutput = div().render
    val stationsUl = ul(stations.map(li(_))).render
    
//    myInput.in
    myInput.onkeyup = (e: dom.Event) => {
      myOutput.innerHTML = myInput.value
      stationsUl.innerHTML = ""
      val searchString = myInput.value.toLowerCase()
//      stations.filter(_.toLowerCase.startsWith(searchString)).foreach { station => 
      stations.filter(_.toLowerCase.contains(searchString)).foreach { station =>

        
        //stationsUl.appendChild(li(station).render)
        val (highlightedText, tail) = station.splitAt(searchString.size)
        stationsUl.appendChild(li(fade,
          span(highlightedImproved, highlightedText), tail
        ).render)
      }
    }
    
	  //js.Dynamic.global.window.alert("Foi mesmo!")
    //js.Dynamic.global.asdasdasd.asasdasd()
    val a: html.Heading = h1(glitter, "Olá, TDC! \\o/\\o/\\o/").render
    container.innerHTML = a.outerHTML
//    container.ap
    container.appendChild(myInput)
    container.appendChild(myOutput)
    container.appendChild(stationsUl)
    
    
    //dom.c
    //container.innerHTML
    //dom.
  }
}
