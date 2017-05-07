package com.builtbroken.turtlearmor.content.boat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/7/2017.
 */
public class EntityBoatArmor extends EntityBoat
{
    public ItemStack armorStack;

    //TODO on collide damage armor

    public EntityBoatArmor(World world)
    {
        super(world);
    }

    public EntityBoatArmor(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected void updateFallState(double p_70064_1_, boolean p_70064_3_)
    {
        //TODO damage armor
    }

    @Override
    protected void onImpactGroundHard()
    {
        
    }

    @Override
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else if (!this.worldObj.isRemote && !this.isDead)
        {
            this.setForwardDirection(-this.getForwardDirection());
            this.setTimeSinceHit(10);
            this.setDamageTaken(this.getDamageTaken() + p_70097_2_ * 10.0F);
            this.setBeenAttacked();
            boolean doBreak = p_70097_1_.getEntity() instanceof EntityPlayer && ((EntityPlayer) p_70097_1_.getEntity()).capabilities.isCreativeMode;

            if (doBreak || this.getDamageTaken() > 40.0F)
            {
                if (this.riddenByEntity != null)
                {
                    this.riddenByEntity.mountEntity(this);
                }

                if (!doBreak && armorStack != null)
                {
                    this.entityDropItem(armorStack, 0);
                }

                this.setDead();
            }

            return true;
        }
        else
        {
            return true;
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        if (armorStack != null)
        {
            NBTTagCompound tag = new NBTTagCompound();
            armorStack.writeToNBT(tag);
            nbt.setTag("armorStack", tag);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        if (nbt.hasKey("armorStack"))
        {
            armorStack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("armorStack"));
        }
    }
}
