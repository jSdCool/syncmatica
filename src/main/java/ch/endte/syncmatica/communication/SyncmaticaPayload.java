package ch.endte.syncmatica.communication;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static ch.endte.syncmatica.Syncmatica.MOD_ID;

public class SyncmaticaPayload implements CustomPayload {
    public static final Identifier ID = new Identifier(MOD_ID,"payload");
    Identifier channel;
    PacketByteBuf data;

    public SyncmaticaPayload(Identifier channel, PacketByteBuf buf){
        this.channel = channel;
        System.out.println(channel);
        data = buf;
    }

    public SyncmaticaPayload(PacketByteBuf buf){
        this.channel = buf.readIdentifier();
        this.data = buf;
    }
    @Override
    public void write(PacketByteBuf buf) {
        buf.writeIdentifier(this.channel);
        buf.writeBytes(this.data);
    }

    @Override
    public Identifier id() {
        return ID;
    }

    public  PacketByteBuf getData(){
        return data;
    }

    public Identifier getChannel(){
        return channel;
    }

}
