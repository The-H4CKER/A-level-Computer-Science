class Chassis {

  Body body;
  float w;
  float h;

  Chassis(float x, float y, float w_, float h_, boolean lock) {
    w = w_;
    h = h_;
    makeBody(x, y, lock);
  }

  void killBody() {
    box2d.destroyBody(body);
  }

  void display() {
    // displays the box on the screen
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();

    rectMode(PConstants.CENTER);
    pushMatrix();
    translate(pos.x, pos.y);
    rotate(-a);
    fill(127);
    stroke(0);
    strokeWeight(1);
    rect(0, 0, w, h);
    popMatrix();
  }

  void makeBody(float x, float y, boolean lock) {
    // Define and create body
    BodyDef bd = new BodyDef();
    bd.position.set(box2d.coordPixelsToWorld(new Vec2(x, y)));
    bd.type = lock ? BodyType.STATIC : BodyType.DYNAMIC;

    body = box2d.createBody(bd);
    // Create shape of chassis
    PolygonShape sd = new PolygonShape();
    float box2dW = box2d.scalarPixelsToWorld(w/2);
    float box2dH = box2d.scalarPixelsToWorld(h/2);
    sd.setAsBox(box2dW, box2dH);

    FixtureDef fd = new FixtureDef();
    fd.shape = sd;
    // Physics Parameters
    fd.density = 1;
    fd.friction = 0.1;
    fd.restitution = 0.5;
    // Define a fixture
    body.createFixture(fd);

    body.setLinearVelocity(new Vec2(0, 0));
    body.setAngularVelocity(0);
  }
  
  Vec2 getPosition() {
    return box2d.getBodyPixelCoord(body);
  }
}
