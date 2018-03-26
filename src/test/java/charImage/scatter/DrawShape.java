package charImage.scatter;

import com.sun.glass.ui.Screen;
import com.sun.javafx.font.FontStrike;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.text.GlyphList;
import com.sun.javafx.sg.prism.NGCamera;
import com.sun.javafx.sg.prism.NGLightBase;
import com.sun.javafx.sg.prism.NodePath;
import com.sun.prism.*;
import com.sun.prism.paint.Color;
import com.sun.prism.paint.Paint;

/**
 * Created by Blong on 2018/3/15.
 */
public class DrawShape implements Graphics {
    @Override
    public BaseTransform getTransformNoClone() {
        return null;
    }

    @Override
    public void setTransform(BaseTransform xform) {

    }

    @Override
    public void setTransform(double m00, double m10, double m01, double m11, double m02, double m12) {

    }

    @Override
    public void setTransform3D(double mxx, double mxy, double mxz, double mxt, double myx, double myy, double myz, double myt, double mzx, double mzy, double mzz, double mzt) {

    }

    @Override
    public void transform(BaseTransform xform) {

    }

    @Override
    public void translate(float tx, float ty) {

    }

    @Override
    public void translate(float tx, float ty, float tz) {

    }

    @Override
    public void scale(float sx, float sy) {

    }

    @Override
    public void scale(float sx, float sy, float sz) {

    }

    @Override
    public void setCamera(NGCamera camera) {

    }

    @Override
    public NGCamera getCameraNoClone() {
        return null;
    }

    @Override
    public void setDepthTest(boolean depthTest) {

    }

    @Override
    public boolean isDepthTest() {
        return false;
    }

    @Override
    public void setDepthBuffer(boolean depthBuffer) {

    }

    @Override
    public boolean isDepthBuffer() {
        return false;
    }

    @Override
    public boolean isAlphaTestShader() {
        return false;
    }

    @Override
    public void setAntialiasedShape(boolean aa) {

    }

    @Override
    public boolean isAntialiasedShape() {
        return false;
    }

    @Override
    public RectBounds getFinalClipNoClone() {
        return null;
    }

    @Override
    public Rectangle getClipRect() {
        return null;
    }

    @Override
    public Rectangle getClipRectNoClone() {
        return null;
    }

    @Override
    public void setHasPreCullingBits(boolean hasBits) {

    }

    @Override
    public boolean hasPreCullingBits() {
        return false;
    }

    @Override
    public void setClipRect(Rectangle clipRect) {

    }

    @Override
    public void setClipRectIndex(int index) {

    }

    @Override
    public int getClipRectIndex() {
        return 0;
    }

    @Override
    public float getExtraAlpha() {
        return 0;
    }

    @Override
    public void setExtraAlpha(float extraAlpha) {

    }

    @Override
    public void setLights(NGLightBase[] lights) {

    }

    @Override
    public NGLightBase[] getLights() {
        return new NGLightBase[0];
    }

    @Override
    public Paint getPaint() {
        return null;
    }

    @Override
    public void setPaint(Paint paint) {

    }

    @Override
    public BasicStroke getStroke() {
        return null;
    }

    @Override
    public void setStroke(BasicStroke stroke) {

    }

    @Override
    public void setCompositeMode(CompositeMode mode) {

    }

    @Override
    public CompositeMode getCompositeMode() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void clear(Color color) {

    }

    @Override
    public void clearQuad(float x1, float y1, float x2, float y2) {

    }

    @Override
    public void fill(Shape shape) {

    }

    @Override
    public void fillQuad(float x1, float y1, float x2, float y2) {

    }

    @Override
    public void fillRect(float x, float y, float width, float height) {

    }

    @Override
    public void fillRoundRect(float x, float y, float width, float height, float arcw, float arch) {

    }

    @Override
    public void fillEllipse(float x, float y, float width, float height) {

    }

    @Override
    public void draw(Shape shape) {

    }

    @Override
    public void drawLine(float x1, float y1, float x2, float y2) {

    }

    @Override
    public void drawRect(float x, float y, float width, float height) {

    }

    @Override
    public void drawRoundRect(float x, float y, float width, float height, float arcw, float arch) {

    }

    @Override
    public void drawEllipse(float x, float y, float width, float height) {

    }

    @Override
    public void setNodeBounds(RectBounds bounds) {

    }

    @Override
    public void drawString(GlyphList gl, FontStrike strike, float x, float y, Color selectColor, int selectStart, int selectEnd) {

    }

    @Override
    public void blit(RTTexture srcTex, RTTexture dstTex, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1) {

    }

    @Override
    public void drawTexture(Texture tex, float x, float y, float w, float h) {

    }

    @Override
    public void drawTexture(Texture tex, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2) {

    }

    @Override
    public void drawTexture3SliceH(Texture tex, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2, float dh1, float dh2, float sh1, float sh2) {

    }

    @Override
    public void drawTexture3SliceV(Texture tex, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2, float dv1, float dv2, float sv1, float sv2) {

    }

    @Override
    public void drawTexture9Slice(Texture tex, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2, float dh1, float dv1, float dh2, float dv2, float sh1, float sv1, float sh2, float sv2) {

    }

    @Override
    public void drawTextureVO(Texture tex, float topopacity, float botopacity, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2) {

    }

    @Override
    public void drawTextureRaw(Texture tex, float dx1, float dy1, float dx2, float dy2, float tx1, float ty1, float tx2, float ty2) {

    }

    @Override
    public void drawMappedTextureRaw(Texture tex, float dx1, float dy1, float dx2, float dy2, float tx11, float ty11, float tx21, float ty21, float tx12, float ty12, float tx22, float ty22) {

    }

    @Override
    public void sync() {

    }

    @Override
    public Screen getAssociatedScreen() {
        return null;
    }

    @Override
    public ResourceFactory getResourceFactory() {
        return null;
    }

    @Override
    public RenderTarget getRenderTarget() {
        return null;
    }

    @Override
    public void setRenderRoot(NodePath root) {

    }

    @Override
    public NodePath getRenderRoot() {
        return null;
    }

    @Override
    public void setState3D(boolean flag) {

    }

    @Override
    public boolean isState3D() {
        return false;
    }

    @Override
    public void setup3DRendering() {

    }

    @Override
    public void setPixelScaleFactor(float pixelScale) {

    }

    @Override
    public float getPixelScaleFactor() {
        return 0;
    }
}
