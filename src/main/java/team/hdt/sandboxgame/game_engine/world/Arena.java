package team.hdt.sandboxgame.game_engine.world;


import team.hdt.sandboxgame.game_engine.util.math.vectors.Vectors3f;


public class Arena {

	public final int X_SIZE = 20, Y_SIZE = 20, Z_SIZE = 20;
	final int CUBE_LENGTH = 1;
	public Block[][][] blocks;

	public Arena() {

	}

	public void genTwoBlocks() {
		blocks = new Block[1][1][2];
		blocks[0][0][0] = new Block(0, 0, 0, Block.BlockType.DIRT);
		blocks[0][0][1] = new Block(0, 0, 1, Block.BlockType.DIRT);
	}

	public boolean inBounds(int x, int y, int z) {
		return (x >= 0 && x < X_SIZE && y >= 0 && y < Y_SIZE && z >= 0 && z < Z_SIZE);
	}

	public void genArena() {
		blocks = new Block[X_SIZE][Y_SIZE][Z_SIZE];
		Block.BlockType type = null;
		for (int x = 0; x < X_SIZE; x++)
			for (int y = 0; y < Y_SIZE; y++)
				for (int z = 0; z < Z_SIZE; z++) {
					if ((y == Y_SIZE - 1 && x == 5 && z == 5) || (y == 15 && x == 10 && z == 10) || (y == Y_SIZE - 6 && x == 10 && z == 11)
							|| (y == 11 && x == 1 && z == 1) || (y == 10 && x == 2 && z == 1))
						type = Block.BlockType.GRASS;
					else if (y > 9 && ((x == 0 || x == X_SIZE - 1) || (z == 0 || z == Z_SIZE - 1))) {
						type = Block.BlockType.DIRT;
					}
					else if (y < 5 || (y == 12 && x == 1 && z == 2))
						type = Block.BlockType.STONE;
					else if (y < Y_SIZE / 2 - 1)
						type = Block.BlockType.DIRT;
					else if (y < Y_SIZE / 2)
						type = Block.BlockType.GRASS;
					else
						type = Block.BlockType.AIR;
					blocks[x][y][z] = new Block(x, y, z, type);
				}
		System.out.println("Done building Arena");
	}

	public void genDemoBlocks() {
		blocks = new Block[6][1][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				switch (i) {
					case 0:
					case 1:
						blocks[i][0][j] = new Block(i, 0, j, Block.BlockType.DIRT);
						break;
					case 2:
					case 3:
						blocks[i][0][j] = new Block(i, 0, j, Block.BlockType.GRASS);
						break;
					case 4:
					case 5:
						blocks[i][0][j] = new Block(i, 0, j, Block.BlockType.STONE);
						break;
				}
			}
		}
	}

	public void generate() {
		blocks = new Block[X_SIZE][Y_SIZE][Z_SIZE];
		System.out.println(blocks.length);
		for (int x = 0; x < X_SIZE; x++)
			for (int y = 0; y < Y_SIZE; y++)
				for (int z = 0; z < Z_SIZE; z++) {
					if (y > 4) {
						blocks[x][y][z] = new Block(x, y, z, Block.BlockType.AIR);
					} else if ((x == 2 || x == 3) && z > 2 && z < 18 && y > 0)
						blocks[x][y][z] = new Block(x, y, z, Block.BlockType.WATER);
					else
						blocks[x][y][z] = new Block(x, y, z, Block.BlockType.DIRT);
				}
		for (int x = 0; x < X_SIZE; x++) {
			blocks[x][5][0] = new Block(x, 5, 0, Block.BlockType.DIRT);
			blocks[x][5][Z_SIZE - 1] = new Block(x, 5, 0, Block.BlockType.DIRT);
		}
		blocks[5][5][5] = new Block(5, 5, 5, Block.BlockType.GRASS);
	}

	public void render() {
		for (Block[][] blockX : blocks)
			for (Block[] blockY : blockX)
				for (Block block : blockY)
					if (block.getType() != Block.BlockType.AIR)
						block.render();
	}

	public boolean contains(Vectors3f pos) {
		return (pos.x >= 0 && pos.x < X_SIZE &&
				pos.y >= 0 && pos.y < Y_SIZE &&
				pos.z >= 0 && pos.z < Z_SIZE);
	}

}