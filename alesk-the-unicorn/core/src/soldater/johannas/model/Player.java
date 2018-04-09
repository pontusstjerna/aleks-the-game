package soldater.johannas.model;

public class Player extends Character implements Movable {

    public static final int WIDTH       = 132;
    public static final int HEIGHT      = 105;
    public static final int STANDING    = 0;
    public static final int RUNNING     = 1;
    public static final int JUMPING     = 2;
    public static final int FALLING     = 3;
    // For pickups
    public static final int WINGS       = 0;
    public static final int BAGUETTE    = 1;
    public static final int ENERGYDRINK = 2;

    private int state = 0;

    // New booleans
    private final boolean[] pickups = {false,false,false};


    public Player() {
        super();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getState() {
        return state;
    }

    public double getYvel() {
        return super.getYvel();
    }

    @Override
    public String getName() {
        return "player";
    }

    @Override
    public void update(double dTime) {
        if (!collisions[DOWN]) {
            applyGravity();
            if(yVel < 0) {
                state = FALLING;
            }
        }

        if(this.isOnGround()){ this.xVel = 0; }

        super.update(dTime);
    }

    @Override
    public void setCollision(int collision, boolean value, double correction) {
        super.setCollision(collision, value, correction);
        if (collision == DOWN) {
            state = STANDING;
        }
    }

    @Override
    public void left () {
        if (!collisions[super.LEFT]) {
            x -= 10;
        }
        direction = Drawable.LEFT;

        if (state != JUMPING && state != FALLING) {
            state = RUNNING;
        }
    }

    @Override
    public void right() {
        if (!collisions[super.RIGHT]) {
            x += 10;
        }
        direction = Drawable.RIGHT;

        if (state != JUMPING && state != FALLING){
            state = RUNNING;
        }
    }

    @Override
    public void jump() {
        if (!collisions[UP] && collisions[DOWN]) {
            yVel = 30;
        }
        if(state != FALLING) {
            state = JUMPING;
        }
    }

    @Override
    public void stop() {
        if (state != JUMPING) {
            state = STANDING;
        }
    }

    public void setPickup(int pickup, boolean value){
        this.pickups[pickup] = value;
    }

    public boolean getPickup(int pickup){
        return this.pickups[pickup];
    }

    private void applyGravity() {
        yVel -= 0.8;
    }
}
