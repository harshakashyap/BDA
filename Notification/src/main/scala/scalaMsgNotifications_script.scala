
object NotifyPeople {

def main(args:Array[String]) {

		abstract class Notification

		case class SMS(mobile:String, msg: String) extends Notification 

		case class Email(emailAddr: String, subject: String, body: String) extends Notification 
		
		def showNotification(notification: Notification): String = {
	  notification match {
		case Email(emailAddr, subject, _) =>
		  s"You got an email from $emailAddr with subject: $subject"
		case SMS(number, message) =>
		  s"You got an SMS from $number! Message: $message"
	  }
	}

		val someSms = SMS("12345", "Are you there?")
		val someEmail = Email("subhrajit.b@nmit.ac.in", "Big Data Course Syllabus",
		  "Intro to Big Data, NOSQL Databases, Spark RDDs, SQL, Streaming")

		println(showNotification(someSms))  

		println(showNotification(someEmail))  
	}
	
	

}
