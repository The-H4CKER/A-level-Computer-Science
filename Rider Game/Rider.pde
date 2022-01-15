import shiffman.box2d.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.*;

Box2DProcessing box2d;

Car car;
Terrain terrain;


void setup() {
  size(1000, 640);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();
  terrain = new Terrain();
 
  car = new Car(100, 100);
}

void draw() {
  translate(width / 2 - car.getPosition().x, height / 2 - car.getPosition().y);
  background(0);
  terrain.display();
  car.display();
  box2d.step();
}

void keyPressed(){
  if (keyCode == RIGHT || keyCode == UP) {
    car.accelerate(car.rj1, 1);
    car.accelerate(car.rj2, 1 );
  } else if (keyCode == LEFT || keyCode == DOWN) {
    car.accelerate(car.rj1, -1);
    car.accelerate(car.rj2, -1);
  } else if (key == ' ') {
        car.brake(car.rj1);
    car.brake(car.rj2);
  }
  
}
