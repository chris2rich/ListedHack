package me.listed.listedhack.mixins;

import me.listed.listedhack.client.event.WurstplusEventBus;
import me.listed.listedhack.client.event.events.EventHorseSaddled;
import me.listed.listedhack.client.event.events.EventSteerEntity;
import net.minecraft.entity.passive.EntityPig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityPig.class})
public class MixinEntityPig {
   @Inject(
      method = {"canBeSteered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void canBeSteered(CallbackInfoReturnable<Boolean> cir) {
      EventSteerEntity event = new EventSteerEntity();
      WurstplusEventBus.EVENT_BUS.post(event);
      if (event.isCancelled()) {
         cir.cancel();
         cir.setReturnValue(true);
      }

   }

   @Inject(
      method = {"getSaddled"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getSaddled(CallbackInfoReturnable<Boolean> cir) {
      EventHorseSaddled event = new EventHorseSaddled();
      WurstplusEventBus.EVENT_BUS.post(event);
      if (event.isCancelled()) {
         cir.cancel();
         cir.setReturnValue(true);
      }

   }
}
