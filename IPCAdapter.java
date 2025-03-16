package com.pandeyrahul.lawleaks.DATA;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.HashSet;
import com.pandeyrahul.lawleaks.R;

public class IPCAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_CHAPTER = 0;
    private static final int TYPE_SECTION = 1;
    private List<IPCItem> items;
    private HashSet<Integer> chapterPositions = new HashSet<>();

    public IPCAdapter(List<IPCItem> items) {
        this.items = items;
        int lastChapter = -1;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getChapter() != lastChapter) {
                chapterPositions.add(i);
                lastChapter = items.get(i).getChapter();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return chapterPositions.contains(position) ? TYPE_CHAPTER : TYPE_SECTION;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_CHAPTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chapter, parent, false);
            return new ChapterViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section, parent, false);
            return new SectionViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        IPCItem item = items.get(position);

        if (holder.getItemViewType() == TYPE_CHAPTER) {
            ((ChapterViewHolder) holder).chapterTitle.setText("📖 Chapter " + item.getChapter() + ": " + item.getChapterTitle());
        } else {
            SectionViewHolder sectionHolder = (SectionViewHolder) holder;
            sectionHolder.sectionTitle.setText("🔹 Section " + item.getSection() + ": " + item.getSectionTitle());

            // Expand/collapse description on click
            sectionHolder.sectionTitle.setOnClickListener(v -> {
                if (sectionHolder.sectionDesc.getVisibility() == View.GONE) {
                    sectionHolder.sectionDesc.setVisibility(View.VISIBLE);
                    sectionHolder.sectionDesc.setText("📜 " + item.getSectionDesc());
                } else {
                    sectionHolder.sectionDesc.setVisibility(View.GONE);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ChapterViewHolder extends RecyclerView.ViewHolder {
        TextView chapterTitle;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterTitle = itemView.findViewById(R.id.chapterTitle);
        }
    }

    static class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTitle, sectionDesc;

        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            sectionTitle = itemView.findViewById(R.id.sectionTitle);
            sectionDesc = itemView.findViewById(R.id.sectionDesc);
            sectionDesc.setVisibility(View.GONE);
        }
    }
}