package adapter;

public class AdapterApp {

    public static void main(String[] args) {
        // 1 способ через наследование

        VectorGraphicInterface gl = new VectorAdapterFromRaster();
        gl.drawLine();
        gl.drawSquare();
        //2 способ через композицию

        VectorGraphicInterface gl2 = new VectorAdapterFromRaster2(new RasterGraphic());
        gl2.drawLine();
        gl2.drawSquare();
    }

}

interface VectorGraphicInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphic{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}


class VectorAdapterFromRaster extends RasterGraphic implements VectorGraphicInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}


class VectorAdapterFromRaster2 implements VectorGraphicInterface{
    RasterGraphic rasterGraphic = null;

    public VectorAdapterFromRaster2(RasterGraphic rasterGraphic) {
        this.rasterGraphic = rasterGraphic;
    }

    @Override
    public void drawLine() {
        rasterGraphic.drawRasterLine();

    }

    @Override
    public void drawSquare() {
        rasterGraphic.drawRasterSquare();

    }
}