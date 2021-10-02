import os
import anyio
import pyrebase
import requests
import json
from itertools import islice
from requests.utils import requote_uri
from signalstickers_client import StickersClient

config = {
    
}

async def all():
    uplink = {}
    data = requests.get('https://api.signalstickers.com/v1/packs/').json()
    for d in islice(data, 20):
        async with StickersClient() as client:
            pack = await client.get_pack(d['meta']["id"], d['meta']["key"])
        uplink['id'] = d['meta']["id"]
        uplink['key'] = d['meta']["key"]
        uplink['title'] = d['manifest']["title"]
        uplink['author'] = d['manifest']["author"]
        uplink['cover'] = requote_uri("https://firebasestorage.googleapis.com/v0/b/production-stickrs.appspot.com/o/assets%2Fcoimgs%2F" + pack.title + "%2F" + "0.webp" + "?alt=media&token=bbac8c98-6acd-4d47-a5ed-cedc2b7bd0d2")
        print(json.dumps(uplink))
        
async def main():
    uplink = {}
    data = requests.get('https://api.signalstickers.com/v1/packs/').json()
    firebase = pyrebase.initialize_app(config)
    storage = firebase.storage()
    for d in islice(data, 20):
            uplink['id'] = d['meta']["id"]
            uplink['key'] = d['meta']["key"]
            uplink['title'] = d['manifest']["title"]
            #print(json.dumps(uplink))
            pack_id = (d['meta']["id"])
            pack_key = (d['meta']["key"])
            async with StickersClient() as client:
                pack = await client.get_pack(pack_id, pack_key)
                
            print(pack.title)  # "Friends of the Internet"
            print(pack.author)  # "Bits of Freedom"
            print(pack.nb_stickers)  # 7
            path = "tmp/" + pack.title
            path_on_cloud = "assets/coimgs/"+ pack.title +"/" + "0.webp"
                
        #        for sticker in pack.stickers:
        #            await tg.spawn(save_sticker, sticker)
            async def save_sticker(sticker):
                try:
                    os.mkdir(path)
                except OSError:
                        async with await anyio.open_file(
                            os.path.join("tmp", pack.title, "{}.webp".format(sticker.id)),
                            "wb",
                        ) as f:
                            await f.write(sticker.image_data)
                else:
                        async with await anyio.open_file(
                            os.path.join("tmp", pack.title, "{}.webp".format(sticker.id)),
                            "wb",
                        ) as f:
                            await f.write(sticker.image_data)
                            
            async with anyio.create_task_group() as tg:
                # Saves all stickers in webp format in /tmp/stickersclient in parallel
                # if the directory exists
                #await tg.spawn(save_sticker, pack.stickers[1])
                path_local = "tmp/"+pack.title+"/1.webp"
                #storage.child(path_on_cloud).put(path_local)
                    
                

    
if __name__ == '__main__':
    anyio.run(all)