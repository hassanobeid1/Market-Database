all: 

compile:
	javac -d bin -cp bin/ojdbc6.jar --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.graphics -sourcepath src src/gui/GUIApplication.java

exe: 
	java -classpath bin/ojdbc6.jar:bin --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.graphics gui.GUIApplication

clean:
	rm -rf bin/*.class
