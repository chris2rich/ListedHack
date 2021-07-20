package me.listed.listedhack.client.hacks;

public enum WurstplusCategory {
   WURSTPLUS_COMBAT("Combat", "WurstplusCombat", false),
   WURSTPLUS_MOVEMENT("Movement", "WurstplusMovement", false),
   WURSTPLUS_OTHER("Other", "WurstplusOther", false),
   WURSTPLUS_EXPLOIT("Exploit", "WurstplusExploit", false),
   WURSTPLUS_VISUAL("Visual", "WurstplusVisual", false),
   WURSTPLUS_CHAT("Chat", "WurstplusChat", false),
   WURSTPLUS_CLIENT("Client", "WurstplusClient", false),
   WURSTPLUS_HIDDEN("Hidden", "WurstplusHidden", true);

   String name;
   String tag;
   boolean hidden;

   private WurstplusCategory(String name, String tag, boolean hidden) {
      this.name = name;
      this.tag = tag;
      this.hidden = hidden;
   }

   public boolean is_hidden() {
      return this.hidden;
   }

   public String get_name() {
      return this.name;
   }

   public String get_tag() {
      return this.tag;
   }
}