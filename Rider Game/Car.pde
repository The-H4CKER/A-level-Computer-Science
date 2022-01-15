class Car {
  Chassis chassis;
  Wheel wheel1;
  Wheel wheel2;
  RevoluteJoint rj1;
  RevoluteJoint rj2;
  
  Car(float x, float y) {
    chassis = new Chassis(x, y, 100, 30, false);
    wheel1 = new Wheel(x-28, y+16, 12);
    wheel2 = new Wheel(x+28, y+16, 12);

    rj1 = joinWheel(wheel1);
    rj2 = joinWheel(wheel2);
  }

  void display() {
    chassis.display();
    wheel1.display();
    wheel2.display();    
  }
  
  RevoluteJoint joinWheel(Wheel wheel) {
    RevoluteJointDef rjd = new RevoluteJointDef();
    rjd.initialize(chassis.body, wheel.body, wheel.body.getWorldCenter());
    //rjd.motorSpeed = 0;
    rjd.maxMotorTorque = 1000;
    rjd.enableMotor = true;
    return (RevoluteJoint) box2d.world.createJoint(rjd);
  }
  
  Vec2 getPosition() {
    return chassis.getPosition();
  }
  
  void accelerate(RevoluteJoint rj, float acceleration) {
    float velocity = rj.getMotorSpeed();
    rj.setMotorSpeed(velocity - acceleration);
  }
  
  void brake(RevoluteJoint rj) {
    rj.setMotorSpeed(0);
  }
  
}
