package me.listed.listedhack.mixins;

import me.listed.listedhack.ListedHack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GuiNewChat.class})
public class WurstplusMixinGuiNewChat {
   @Redirect(
      method = {"drawChat"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V",
   ordinal = 0
)
   )
   private void overrideChatBackgroundColour(int left, int top, int right, int bottom, int color) {
      if (!ListedHack.get_hack_manager().get_module_with_tag("ClearChatbox").is_active()) {
         Gui.func_73734_a(left, top, right, bottom, color);
      }

   }
}
