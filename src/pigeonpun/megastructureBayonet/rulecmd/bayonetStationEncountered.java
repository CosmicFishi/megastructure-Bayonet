package pigeonpun.megastructureBayonet.rulecmd;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;
import com.fs.starfarer.api.util.Misc;
import pigeonpun.megastructureBayonet.structure.bayonetManager;

import java.util.List;
import java.util.Map;

public class bayonetStationEncountered extends BaseCommandPlugin {
    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Misc.Token> params, Map<String, MemoryAPI> memoryMap) {
        //unused - adding via bayonetFleetEventListener
        if(dialog.getInteractionTarget() != null && dialog.getInteractionTarget() instanceof CampaignFleetAPI && dialog.getInteractionTarget().getMemoryWithoutUpdate().get(bayonetManager.BAYONET_ENTITY_ID) != null) {
            Global.getSector().getMemoryWithoutUpdate().set("$bayonet_isFleetEncounter", true);
        }
        return false;
    }
}
