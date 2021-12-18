package view.workspaceView;

import controller.observers.Subsriber;
import model.workspace.Slot;

import java.awt.*;

public class SlotView implements Subsriber {
    private Slot slot;
    private Shape shape;
    private int height;
    private int width;
    private int x;
    private int y;
    private int strokeSize;


    public SlotView(Slot slot) {
        this.slot = slot;
        slot.addSubscriber(this);
        this.height = slot.getHeight();
        this.width = slot.getWidth();
        this.x = slot.getX();
        this.y = slot.getY();
        this.strokeSize = slot.getStrokeSize();
        shape = new Rectangle(x, y, width, height);
    }

    public void paint(Graphics2D g){
        g.setPaint(new Color(slot.getRed(), slot.getGreen(), slot.getBlue(), 150));
        g.fill(new Rectangle(x, y, width, height));
        if(slot.getStrokeType() == 0)
            g.setStroke(new BasicStroke(strokeSize));
        else
            g.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{9}, 0));
        g.drawRect(x, y, width, height);
    }

    public boolean elementAt(Point pos){
        return shape.contains(pos);
    }

    public Slot getSlot() {
        return slot;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void updateSubsriber(Object notification, String message) {
        this.x = slot.getX();
        this.y = slot.getY();
        ((Rectangle)shape).setLocation(x, y);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
