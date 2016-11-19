package BiomeMaster.util.math;

import cn.nukkit.entity.Entity;
import BiomeMaster.util.EnumFacing;

public class RayTraceResult {
    private BlockPos blockPos;

    /** What type of ray trace hit was this? 0 = block, 1 = entity */
    public RayTraceResult.Type typeOfHit;
    public EnumFacing sideHit;

    /** The vector position of the hit */
    public Vec3d hitVec;

    /** The hit entity */
    public Entity entityHit;

    public RayTraceResult(Vec3d hitVecIn, EnumFacing sideHitIn, BlockPos blockPosIn) {
        this(RayTraceResult.Type.BLOCK, hitVecIn, sideHitIn, blockPosIn);
    }

    public RayTraceResult(Vec3d hitVecIn, EnumFacing sideHitIn) {
        this(RayTraceResult.Type.BLOCK, hitVecIn, sideHitIn, BlockPos.ORIGIN);
    }

    public RayTraceResult(Entity entityIn) {
        this(entityIn, new Vec3d(entityIn.posX, entityIn.posY, entityIn.posZ));
    }

    public RayTraceResult(RayTraceResult.Type typeIn, Vec3d hitVecIn, EnumFacing sideHitIn, BlockPos blockPosIn) {
        this.typeOfHit = typeIn;
        this.blockPos = blockPosIn;
        this.sideHit = sideHitIn;
        this.hitVec = new Vec3d(hitVecIn.xCoord, hitVecIn.yCoord, hitVecIn.zCoord);
    }

    public RayTraceResult(Entity entityHitIn, Vec3d hitVecIn) {
        this.typeOfHit = RayTraceResult.Type.ENTITY;
        this.entityHit = entityHitIn;
        this.hitVec = hitVecIn;
    }

    public BlockPos getBlockPos() {
        return this.blockPos;
    }

    public String toString() {
        return "HitResult{type=" + this.typeOfHit + ", blockpos=" + this.blockPos + ", f=" + this.sideHit + ", pos=" + this.hitVec + ", entity=" + this.entityHit + '}';
    }

    public static enum Type {
        MISS,
        BLOCK,
        ENTITY;
    }
}