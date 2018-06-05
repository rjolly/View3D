mkdir("build");
mkdir("build/classes");

javac("src", "build/classes");

mkdir("dist");
jar("dist/View3D.jar", "build/classes");

publish("dist")
