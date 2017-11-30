package net.thegaminghuskymc.sandboxgame.engine.block;

import net.thegaminghuskymc.sandboxgame.engine.graph.Mesh;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Block {

    private boolean selected;

    private Mesh[] meshes;

    private final Vector3f position;

    private float scale;

    private final Quaternionf rotation;

    private int textPos;

    private boolean disableFrustumCulling;

    private boolean insideFrustum;

    private float[] positions = new float[] {
            // V0
            -1f, 1f, 1f,
            // V1
            -1f, -1f, 1f,
            // V2
            1f, -1f, 1f,
            // V3
            1f, 1f, 1f,
            // V4
            -1f, 1f, -1f,
            // V5
            1f, 1f, -1f,
            // V6
            -1f, -1f, -1f,
            // V7
            1f, -1f, -1f,

            // For text coords in top face
            // V8: V4 repeated
            -1f, 1f, -1f,
            // V9: V5 repeated
            1f, 1f, -1f,
            // V10: V0 repeated
            -1f, 1f, 1f,
            // V11: V3 repeated
            1f, 1f, 1f,

            // For text coords in right face
            // V12: V3 repeated
            1f, 1f, 1f,
            // V13: V2 repeated
            1f, -1f, 1f,

            // For text coords in left face
            // V14: V0 repeated
            -1f, 1f, 1f,
            // V15: V1 repeated
            -1f, -1f, 1f,

            // For text coords in bottom face
            // V16: V6 repeated
            -1f, -1f, -1f,
            // V17: V7 repeated
            1f, -1f, -1f,
            // V18: V1 repeated
            -1f, -1f, 1f,
            // V19: V2 repeated
            1f, -1f, 1f,
    };
    private float[] textCoords = new float[]{
            0.0f, 0.0f,
            0.0f, 0.5f,
            0.5f, 0.5f,
            0.5f, 0.0f,

            0.0f, 0.0f,
            0.5f, 0.0f,
            0.0f, 0.5f,
            0.5f, 0.5f,

            // For text coords in top face
            0.0f, 0.5f,
            0.5f, 0.5f,
            0.0f, 1.0f,
            0.5f, 1.0f,

            // For text coords in right face
            0.0f, 0.0f,
            0.0f, 0.5f,

            // For text coords in left face
            0.5f, 0.0f,
            0.5f, 0.5f,

            // For text coords in bottom face
            0.5f, 0.0f,
            1.0f, 0.0f,
            0.5f, 0.5f,
            1.0f, 0.5f,
    };
    private int[] indices = new int[]{
            // Front face
            0, 1, 3, 3, 1, 2,
            // Top Face
            8, 10, 11, 9, 8, 11,
            // Right face
            12, 13, 7, 5, 12, 7,
            // Left face
            6, 14, 15, 4, 14, 6,
            // Bottom face
            19, 18, 16, 19, 16, 17,
            // Back face
            7, 6, 4, 7, 4, 5
    };
    private float[] normals = new float[]{
            // V0
            -1.0f, 1.0f, 1.0f,
            // V1
            -1.0f, -1.0f, 1.0f,
            // V2
            1.0f, -1.0f, 1.0f,
            // V3
            1.0f, 1.0f, 1.0f,
            // V4
            -1.0f, 1.0f, -1.0f,
            // V5
            1.0f, 1.0f, -1.0f,
            // V6
            -1.0f, -1.0f, -1.0f,
            // V7
            1.0f, -1.0f, -1.0f,

            // For text coords in top face
            // V8: V4 repeated
            -1.0f, 1.0f, -1.0f,
            // V9: V5 repeated
            1.0f, 1.0f, -1.0f,
            // V10: V0 repeated
            -1.0f, 1.0f, 1.0f,
            // V11: V3 repeated
            1.0f, 1.0f, 1.0f,

            // For text coords in right face
            // V12: V3 repeated
            1.0f, 1.0f, 1.0f,
            // V13: V2 repeated
            1.0f, -1.0f, 1.0f,

            // For text coords in left face
            // V14: V0 repeated
            -1.0f, 1.0f, 1.0f,
            // V15: V1 repeated
            -1.0f, -1.0f, 1.0f,

            // For text coords in bottom face
            // V16: V6 repeated
            -1.0f, -1.0f, -1.0f,
            // V17: V7 repeated
            1.0f, -1.0f, -1.0f,
            // V18: V1 repeated
            -1.0f, -1.0f, 1.0f,
            // V19: V2 repeated
            1.0f, -1.0f, 1.0f,
    };

    public Block() {
        selected = false;
        position = new Vector3f(0, 0, 0);
        scale = 2;
        rotation = new Quaternionf();
        textPos = 0;
        insideFrustum = true;
        disableFrustumCulling = false;
    }

    public Block(Mesh mesh) {
        this();
        this.meshes = new Mesh[]{mesh};
    }

    public Block(Mesh[] meshes) {
        this();
        this.meshes = meshes;
    }

    public Vector3f getPosition() {
        return position;
    }

    public int getTextPos() {
        return textPos;
    }

    public boolean isSelected() {
        return selected;
    }

    public final void setPosition(float x, float y, float z) {
        this.position.x = x;
        this.position.y = y;
        this.position.z = z;
    }

    public float getScale() {
        return scale;
    }

    public final void setScale(float scale) {
        this.scale = scale;
    }

    public Quaternionf getRotation() {
        return rotation;
    }

    public final void setRotation(Quaternionf q) {
        this.rotation.set(q);
    }

    public Mesh getMesh() {
        return meshes[0];
    }

    public Mesh[] getMeshes() {
        return meshes;
    }

    public void setMeshes(Mesh[] meshes) {
        this.meshes = meshes;
    }

    public void setMesh(Mesh mesh) {
        this.meshes = new Mesh[]{mesh};
    }

    public void cleanup() {
        int numMeshes = this.meshes != null ? this.meshes.length : 0;
        for (int i = 0; i < numMeshes; i++) {
            this.meshes[i].cleanUp();
        }
    }

    public int[] getIndices() {
        return indices;
    }

    public float[] getTextCoords() {
        return textCoords;
    }

    public float[] getPositions() {
        return positions;
    }

    public float[] getNormals() {
        return normals;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setTextPos(int textPos) {
        this.textPos = textPos;
    }

    public boolean isInsideFrustum() {
        return insideFrustum;
    }

    public void setInsideFrustum(boolean insideFrustum) {
        this.insideFrustum = insideFrustum;
    }

    public boolean isDisableFrustumCulling() {
        return disableFrustumCulling;
    }

    public void setDisableFrustumCulling(boolean disableFrustumCulling) {
        this.disableFrustumCulling = disableFrustumCulling;
    }

}