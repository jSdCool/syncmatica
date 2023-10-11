package ch.endte.syncmatica.communication;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class SyncmaticaPayload implements CustomPayload {
    Identifier channel;
    PacketByteBuf data;

    public SyncmaticaPayload(Identifier channel, PacketByteBuf buf){
        this.channel = channel;
        data = buf;
    }
    @Override
    public void write(PacketByteBuf buf) {
        buf.writeIdentifier(this.channel);
        buf.writeBytes(this.data);
    }

    @Override
    public Identifier id() {
        return channel;
    }

    public  PacketByteBuf getData(){
        return data;
    }

    public Identifier getChannel(){
        return channel;
    }

}
