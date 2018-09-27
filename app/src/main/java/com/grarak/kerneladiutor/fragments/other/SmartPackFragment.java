/*
 * Copyright (C) 2018-2019 sunilpaulmathew <sunil.kde@gmail.com>
 *
 * This file is part of SmartPack Kernel Manager, which is heavily modified version of Kernel Adiutor,
 * originally developed by Willi Ye <williye97@gmail.com>
 *
 * Both SmartPack Kernel Manager & Kernel Adiutor are free softwares: you can redistribute it 
 * and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kernel Adiutor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kernel Adiutor.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.grarak.kerneladiutor.fragments.other;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import com.grarak.kerneladiutor.R;
import com.grarak.kerneladiutor.fragments.RecyclerViewFragment;
import com.grarak.kerneladiutor.utils.Device;
import com.grarak.kerneladiutor.utils.root.RootUtils;
import com.grarak.kerneladiutor.utils.Utils;
import com.grarak.kerneladiutor.views.recyclerview.CardView;
import com.grarak.kerneladiutor.views.recyclerview.DescriptionView;
import com.grarak.kerneladiutor.views.recyclerview.RecyclerViewItem;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by sunilpaulmathew <sunil.kde@gmail.com> on July 24, 2018
 */

public class SmartPackFragment extends RecyclerViewFragment {

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected boolean showViewPager() {
        return false;
    }

    @Override
    protected void addItems(List<RecyclerViewItem> items) {
        SmartPackInit(items);
    }

    private void SmartPackInit(List<RecyclerViewItem> items) {

	CardView smartpack = new CardView(getActivity());
	smartpack.setTitle(getString(R.string.smartpack_kernel));

	if ((Device.hasSmartPackInstalled()) && (Build.VERSION.SDK_INT >= 27)) {
            DescriptionView currentspversion = new DescriptionView();
            currentspversion.setTitle(("Current ") + getString(R.string.version));
            if (Device.hasSmartPackVersion()) {
		currentspversion.setSummary(Device.getSmartPackVersion());
            } else {
		currentspversion.setSummary(RootUtils.runCommand("uname -r"));
            }
            smartpack.addItem(currentspversion);

            DescriptionView xdapage = new DescriptionView();
            xdapage.setTitle(getString(R.string.support));
            xdapage.setSummary(getString(R.string.support_summary));
            xdapage.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
		@Override
		public void onClick(RecyclerViewItem item) {
            		if (Device.isSamsungmsm8974()) {
				Utils.launchUrl("https://forum.xda-developers.com/galaxy-s5/unified-development/kernel-project-kltexxx-t3564206", getActivity());
			} else if (Device.isOnePlusmsm8998()) {
				Utils.launchUrl("https://forum.xda-developers.com/oneplus-5t/development/kernel-smartpack-linaro-gcc-7-x-oxygen-t3832458", getActivity());
			} else if (Device.isMotoG3()) {
				Utils.launchUrl("https://forum.xda-developers.com/2015-moto-g/orig-development/kernel-smartpack-linaro-gcc-7-x-lineage-t3834515", getActivity());
			}
		}
            });
            smartpack.addItem(xdapage);

            DescriptionView changelogsp = new DescriptionView();
            changelogsp.setTitle(getString(R.string.change_logs));
            changelogsp.setSummary(getString(R.string.change_logs_summary));
            changelogsp.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
		@Override
		public void onClick(RecyclerViewItem item) {
			if (Device.isSamsungmsm8974()) {
				Utils.launchUrl("https://raw.githubusercontent.com/SmartPack/SmartPack-Kernel-Project_kltexxx/Oreo/change-logs.md", getActivity());
			} else if (Device.isOnePlusmsm8998()) {
				if (Device.isOnePlusOpenBeta()) {
					Utils.launchUrl("https://raw.githubusercontent.com/SmartPack/SmartPack-Kernel-Project_OP5T/Oreo_Beta/change-logs.md", getActivity());
				} else {
					Utils.launchUrl("https://raw.githubusercontent.com/SmartPack/SmartPack-Kernel-Project_OP5T/Oreo/change-logs.md", getActivity());
				}
			} else if (Device.isMotoG3()) {
				Utils.launchUrl("https://raw.githubusercontent.com/SmartPack/SmartPack-Kernel-Project_osprey/Oreo/change-logs.md", getActivity());
			}
            	}
            });
            smartpack.addItem(changelogsp);

            DescriptionView spsource = new DescriptionView();
            spsource.setTitle(getString(R.string.source_code));
            spsource.setSummary(getString(R.string.source_code_summary));
            spsource.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
		@Override
		public void onClick(RecyclerViewItem item) {
			if (Device.isSamsungmsm8974()) {
				Utils.launchUrl("https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx", getActivity());
			} else if (Device.isOnePlusmsm8998()) {
				Utils.launchUrl("https://github.com/SmartPack/SmartPack-Kernel-Project_OP5T", getActivity());
			} else if (Device.isMotoG3()) {
				Utils.launchUrl("https://github.com/SmartPack/SmartPack-Kernel-Project_osprey", getActivity());
			}
		}
            });
            smartpack.addItem(spsource);
	}

	DescriptionView website = new DescriptionView();
	website.setTitle(getString(R.string.website));
	website.setSummary(getString(R.string.website_summary));
	website.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
		Utils.launchUrl("https://sunilpaulmathew.github.io/smartpack/", getActivity());
            }
	});

	smartpack.addItem(website);

	DescriptionView downloads = new DescriptionView();
	downloads.setTitle(getString(R.string.downloads));
	downloads.setSummary(getString(R.string.downloads_summary));
	downloads.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
		// Check and delete an old version of the kernel from the download folder, if any...
		if (Device.isSmartPackDownloaded()) {
			RootUtils.runCommand("rm -rf /sdcard/Download/SmartPack-Kernel.zip");
		}
		// Initiate device specific downloads...
		if (Device.iskltekor()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx/blob/Oreo/kernel-release/SmartPack-Kernel-kltekor.zip?raw=true");
			}
		} else if (Device.isklte()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx/blob/Oreo/kernel-release/SmartPack-Kernel-klte.zip?raw=true");
			}
		} else if (Device.iskltedv()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx/blob/Oreo/kernel-release/SmartPack-Kernel-kltedv.zip?raw=true");
			}
		} else if (Device.isklteduos()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx/blob/Oreo/kernel-release/SmartPack-Kernel-klteduos.zip?raw=true");
			}
		} else if (Device.iskltejpn()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_kltexxx/blob/Oreo/kernel-release/SmartPack-Kernel-kltekdi.zip?raw=true");
			}
		} else if (Device.isOnePlusmsm8998()) {
			if (Build.VERSION.SDK_INT == 27) {
		            if (Device.isOnePlusOpenBeta()) {
				RootUtils.runCommand("curl -L -o /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_OP5T/blob/Oreo_Beta/kernel-release/SmartPack-Kernel-dumpling-OB.zip?raw=true");
		            } else {
				RootUtils.runCommand("curl -L -o /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_OP5T/blob/Oreo/kernel-release/SmartPack-Kernel-dumpling.zip?raw=true");
		            }
			}
		} else if (Device.isMotoG3()) {
			if (Build.VERSION.SDK_INT == 27) {
		            RootUtils.runCommand("wget -O /sdcard/Download/SmartPack-Kernel.zip https://github.com/SmartPack/SmartPack-Kernel-Project_osprey/blob/Oreo/kernel-release/SmartPack-Kernel-osprey.zip?raw=true");
			}
		}
		// Proceed only if the download was successful...
		if (Device.isSmartPackDownloaded()) {
		    // Show Auto-flash message if we recognize recovery...
		    if (Device.hasRecovery()) {
			AlertDialog.Builder flash = new AlertDialog.Builder(getActivity());
			flash.setTitle(getString(R.string.autoflash));
			flash.setMessage(getString(R.string.flash_message));
			flash.setNegativeButton(getString(R.string.manual_flashing), (dialogInterface, i) -> {
			});
			flash.setPositiveButton(getString(R.string.install_now), (dialog1, id1) -> {
		            RootUtils.runCommand("echo --update_package=/sdcard/Download/SmartPack-Kernel.zip > /cache/recovery/command");
		            RootUtils.runCommand("reboot recovery");
			});
			flash.show();
		    // If not, show an "Auto-flash not possible" message...
		    } else {
			AlertDialog.Builder noflash = new AlertDialog.Builder(getActivity());
			noflash.setTitle(getString(R.string.warning));
			noflash.setMessage(getString(R.string.no_flash_message));
			noflash.setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> {
			});
			noflash.setPositiveButton(getString(R.string.reboot), (dialog1, id1) -> {
		            RootUtils.runCommand("reboot recovery");
			});
			noflash.show();
		    }
		// Shown "Download failed" message...
		} else {
		    AlertDialog.Builder downloadfailed = new AlertDialog.Builder(getActivity());
		    downloadfailed.setTitle(getString(R.string.appupdater_download_filed));
		    downloadfailed.setMessage(getString(R.string.no_internet));
		    downloadfailed.setPositiveButton(getString(R.string.exit), (dialog1, id1) -> {
		    });
		    downloadfailed.show();
		    }
		} 
	});
	smartpack.addItem(downloads);

        DescriptionView reset = new DescriptionView();
        reset.setTitle(getString(R.string.reset_settings));
        reset.setSummary(getString(R.string.reset_settings_summary));
        reset.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
            AlertDialog.Builder resetsettings = new AlertDialog.Builder(getActivity());
            resetsettings.setTitle(getString(R.string.warning));
            resetsettings.setMessage(getString(R.string.reset_settings_message));
            resetsettings.setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> {
            });
            resetsettings.setPositiveButton(getString(R.string.yes), (dialog1, id1) -> {
            AlertDialog.Builder reboot = new AlertDialog.Builder(getActivity());
            reboot.setTitle(getString(R.string.reboot));
            reboot.setMessage(getString(R.string.reboot_message));
            reboot.setNegativeButton(getString(R.string.reboot_later), (dialogInterface, i) -> {
		RootUtils.runCommand("rm -rf /data/com.smartpack.kernelmanager");
		RootUtils.runCommand("pm clear com.smartpack.kernelmanager && am start -n com.smartpack.kernelmanager/com.grarak.kerneladiutor.activities.MainActivity");
            });
            reboot.setPositiveButton(getString(R.string.reboot_now), (dialog2, id2) -> {
		RootUtils.runCommand("rm -rf /data/com.smartpack.kernelmanager");
		RootUtils.runCommand("pm clear com.smartpack.kernelmanager && reboot");
		    });
		reboot.show();
		});
            resetsettings.show();
            }
	});

	DescriptionView recoveryreboot = new DescriptionView();
	recoveryreboot.setTitle(getString(R.string.reboot_recovery));
	recoveryreboot.setSummary(getString(R.string.reboot_recovery_summary));
	recoveryreboot.setOnItemClickListener(new RecyclerViewItem.OnItemClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
            AlertDialog.Builder flash = new AlertDialog.Builder(getActivity());
            flash.setTitle(getString(R.string.sure_question));
            flash.setMessage(getString(R.string.recovery_message));
            flash.setNegativeButton(getString(R.string.cancel), (dialogInterface, i) -> {
            });
            flash.setPositiveButton(getString(R.string.reboot), (dialog1, id1) -> {
		RootUtils.runCommand("reboot recovery");
            });
            flash.show();
            }
	});

	smartpack.addItem(reset);
	smartpack.addItem(recoveryreboot);
	items.add(smartpack);
    }

    public static boolean supported() {
        return Device.hasSmartPackVersion() || Device.isSamsungmsm8974() || Device.isOnePlusmsm8998() || Device.isMotoG3() || Device.hasSmartPackInstalled();
    }

}